package remote;

import java.util.Collection;

import javax.ejb.Remote;

import model.Activity;
import model.Avancement;

import model.Employee;

import model.Project;

@Remote
public interface FActivityServicesRemote {
	 public void addItem(Activity i);

	    public Activity findItem(Integer id) ;

	    public void deleteItem(Activity i) ;

	    public void updateItem(Activity i) ;
	    
	    public void ajouterCharge(Integer idActivity, Integer chargeAAjouter, Integer idEmployee);
	    ;
	    public String findItemProjectName(Integer id);
	    
	    public String findItemEmployeeName(Integer id);
	    
	    public void modifierEmployee(Integer id, Integer idEmployee);
	    
	    public int getNombreHeures(Integer id);
	    
	    public Collection<Avancement> getAllAvancementByActivity(Integer id);
	    
	    public Collection<Activity> getAllActivitiesFromProject(Project project);

}
