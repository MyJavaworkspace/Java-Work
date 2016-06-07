import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/hrdtest";
		String username="postgres";
		String pass="123";
		try{
			//load driver
			Class.forName("org.postgresql.Driver");
			//define connection url
			Connection cnn= DriverManager.getConnection(url,username,pass);
			System.out.println("Successfully");
			/*
			Statement stm= cnn.createStatement();
			String sql="select * from tbStudent Order By id" ;
			ResultSet rs= stm.executeQuery(sql);
			while(rs.next()){
				int id= rs.getInt(1);
				String name=rs.getString(2);
				String sex= rs.getString(3);
				System.out.println(id+" "+ name+" "+ sex);
			}
			rs.close();
			stm.close();
			cnn.close();
			*/
			String sql="select * from tbStudent where id>? Order By id";
			
			PreparedStatement sp= cnn.prepareStatement(sql);
			sp.setInt(1, 1);
			ResultSet rs= sp.executeQuery();
			while(rs.next()){
				int id= rs.getInt(1);
				String name=rs.getString(2);
				String sex= rs.getString(3);
				System.out.println(id+" "+ name+" "+ sex);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
