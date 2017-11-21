/**
 * 
 */
package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dbconstants.TokenDBConstants;
import utils.Constants;

/**
 * @author thirunavukkarasu
 *
 */
public class InsertTokenClass {
	public static boolean insertToken(int UserProfileId,String Token){
		Connection connection=null;
		Statement st=null;
		boolean value=false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Token="'"+Token+"'";
			String query="CALL `Company.Token_InsertToken`("+UserProfileId+","+Token+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			 value=st.execute(query);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try{
					connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(st!=null){
				try{
					st.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return value;
	}
	public static boolean findTokenIfExist(String Token){
		boolean value=false;
		Connection connection=null;
		Statement st=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Token="'"+Token+"'";
			String query="CALL `Company.Token_GetToken`("+Token+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
			st=connection.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				int tokenId=rs.getInt(TokenDBConstants.TOKEN_ID);
				String token=rs.getString(TokenDBConstants.TOKEN);
				String createdDate=rs.getString(TokenDBConstants.CREATED_DATE);
				String modifiedDate=rs.getString(TokenDBConstants.MODIFIED_DATE);
				if(tokenId!=0&&token!=null){
					value=true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try{
					connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(st!=null){
				try{
					st.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return value;
	}

}
