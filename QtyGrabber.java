import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//Uses subject interface to update all observers


public class QtyGrabber implements Subject {
	private int Qty;
	private String item;
	private ArrayList<Observer> observers;
	public QtyGrabber(){
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(customer newObserver) {
		// TODO Auto-generated method stub
	
		int id = newObserver.getID();
		String name = newObserver.getname();
		int accesslvl = newObserver.getaccesslvl();
		String password = newObserver.getPassword();
		String email = newObserver.getEmail();
		String address = newObserver.getAddress();
		observers.add(newObserver);
		
		
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/creationary", "root", "");
			Statement mystat = myConn.createStatement();
			
			String sql = "INSERT INTO arrayList VALUES('" + id + "',' " + name + "' , '" + accesslvl + "', '" + password + "', '" + email + "', '"  + address  +"')";
			System.out.println(sql);
			mystat.executeUpdate(sql);	
		
		}
		catch(Exception ex){
			System.out.println(" couldnt update arraylist ");
		}
	}

	@Override
	public void removeObserver(customer deleteObserver) {
		// Get the index of the observer to delete
		int observerIndex = observers.indexOf(deleteObserver);
		System.out.println("Observer " + (observerIndex+1) + " deleted");
		observers.remove(observerIndex);
	}

	@Override
	public void notifyObservers() {
			
		customer arrayLine = new customer();
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/creationary", "root", "");
			Statement mystat = myConn.createStatement();
			
			String sql = "select * from arrayList ";
			ResultSet myRe = mystat.executeQuery(sql);
			
			while(myRe.next()){
				arrayLine.setID(myRe.getInt(1));
				arrayLine.setName(myRe.getString(2));
				arrayLine.setPassword(myRe.getString(4));
				arrayLine.setEmail(myRe.getString(5));
				arrayLine.setAddress(myRe.getString(6));
				observers.add(arrayLine);
			}
			
		}
		catch(Exception ex){
			
		}
		
		
		
		for(Observer observer: observers){
			observer.update(Qty,item);
		}
	}
	
	public void setQty(String item , int Qty)
	{
		this.item = item;
		this.Qty = Qty;
		
		notifyObservers();
	}
	
		
}


