package chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.HibernateValidator;
import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.api.jms.JMSFactoryType;
import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;

import remote.FConversationServicesRemote;
import remote.FEmployeeServicesRemote;
import remote.FMessageServicesRemote;

import model.Conversation;
import model.Employee;
import model.Message;

@ManagedBean
@RequestScoped
public class Talking {

	// Properties ---------------------------------------------------------------------------------
	@EJB
	private FMessageServicesRemote fms; 
	@EJB
	private FConversationServicesRemote fcs; 
	@EJB
    private FEmployeeServicesRemote fes; 
	
	private ArrayList<Message> listMessages;
	private Employee curentEmp;
	private Employee contact;
	private Conversation convers;

	
	// Actions ------------------------------------------------------------------------------------
	
	public void init() {		
		Map<String, Object> userSession = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
		
		// If the user is logged in
		if( ! userSession.isEmpty() ) {
			curentEmp = fes.findItem((String) userSession.get("username"));
		}
		// Isn't logged in, redirect to login page
		else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect(
						FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + 
						"/login.xhtml"
					);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		int error = 0;		
		
		try {
    		String GET = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("conversation");
    		// If the conversation is defined
    		if( GET != null ) {
    			convers = fcs.findItem(Integer.parseInt(GET));
    			if( convers != null) {
    				Employee called = convers.getEmployeeByCalledIdemployee();
    				Employee caller = convers.getEmployeeByCallerIdemployee();
    				
    				// If the caller is the current employee then contact is the called employee
    				if( called.getIdemployee() == curentEmp.getIdemployee() ) {
    					contact = caller;
    				}
    				// The other way around
    				else if ( caller.getIdemployee() == curentEmp.getIdemployee() ) {
    					contact = called;
    				}
    				else error = 1;
    			} else error = 2;
    		}
    		else
    			error = 3;
    		
    		// An error occurred => 404 conversation
    		if( error > 0 ) {
    			try {
					FacesContext.getCurrentInstance().getExternalContext().redirect(
							FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + 
							"/chat/infos/talking-notfound.xhtml"
						);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		else {
    			listMessages = fms.getMessagesByIdConversation(convers.getIdconversation());
    		}
    	}
    	catch( NullPointerException e ) {
    		;
    	}
		
	}

	// Getters/setters ----------------------------------------------------------------------------
	
	public ArrayList<Message> getListMessages() {
		return listMessages;
	}


	public void setListMessages(ArrayList<Message> listMessages) {
		this.listMessages = listMessages;
	}


	public Employee getCurentEmp() {
		return curentEmp;
	}


	public void setCurentEmp(Employee curentEmp) {
		this.curentEmp = curentEmp;
	}


	public Employee getContact() {
		return contact;
	}


	public void setContact(Employee contact) {
		this.contact = contact;
	}


	public Conversation getConvers() {
		return convers;
	}


	public void setConvers(Conversation convers) {
		this.convers = convers;
	}
	
	public String getFullName(Message mes)  {
		return mes.getEmployee().getFirstname() + " " + mes.getEmployee().getLastname();
	}
	
	public void sendMessage(String content){
		 TransportConfiguration transportConfiguration =
                 new TransportConfiguration(
         NettyConnectorFactory.class.getName());  

 ConnectionFactory factory = (ConnectionFactory)
     HornetQJMSClient.createConnectionFactoryWithoutHA(
         JMSFactoryType.CF,
         transportConfiguration);

 //The queue name should match the jms-queue name in standalone.xml
 Queue queue = HornetQJMSClient.createQueue("testQueue");
 Connection connection;
 try {
     connection = factory.createConnection();
     Session session = connection.createSession(
                 false,
                 QueueSession.AUTO_ACKNOWLEDGE);
     MessageProducer producer = session.createProducer(queue);
     ObjectMessage objMsg = session.createObjectMessage();

     Message msg = new Message();
     msg.setContent(content);     
     msg.setConversation(fcs.findItem(1)
     		);
     msg.setSendTime(new Date());
     
     objMsg.setObject(msg);
     producer.send(objMsg);   
     session.close();
 } catch (JMSException e) {
     e.printStackTrace();
 }
	}
	
}
