package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import response.DealResponse;
import model.DealModel;
import model.OrganizationModel;
import model.PersonModel;
import utils.Constants;
import dbconstants.OrganizationDBConstants;

public class InsertDealPipeDriveClass {
	public static DealResponse insertDealPipeDrive(DealModel model){
		Connection connection=null;
		CallableStatement callableStatement=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		DealResponse response=new DealResponse();
		OrganizationModel orgModel=new OrganizationModel();
		orgModel.setName(model.getOrgName());
		orgModel.setPeopleCount(model.getPeopleCount());
		orgModel.setOpenDealsCount(model.getOpenDealsCount());
		orgModel.setOwnerName(model.getOwnerName());
		orgModel.setVisibleTo(model.getVisibleTo());
		orgModel.setOwnersUserProfileId(model.getUserProfileId());
		orgModel.setCompanyCode(model.getCompanyCode());
		orgModel.setActiveFlag(model.getActive());
		
		
		int orgValue=insertOrganization(orgModel);
		if(orgValue!=0){
			PersonModel perModel=new PersonModel();
			perModel.setName(model.getPersonName());
			perModel.setOrgName(model.getOrgName());
			perModel.setOrgId(orgValue);
			perModel.setOpenDealsCount(model.getOpenDealsCount());
			perModel.setOwnerName(model.getOwnerName());
			perModel.setVisibleTo(model.getVisibleTo());
			perModel.setCompanyCode(model.getCompanyCode());
			perModel.setUserProfileId(model.getUserProfileId());
			perModel.setActiveFlag(model.getActive());
			int perValue=insertPerson(perModel);
			if(perValue!=0){
				String title=model.getTitle();
				System.out.println("Title : "+title);
				int value=model.getValue();
				System.out.println("Value : "+value);
				String currency=model.getCurrency();
				System.out.println("Currency : "+currency);
				int stageId=model.getStageId();
				System.out.println("StageId : "+stageId);
				int pipeLineId=model.getPipeLineId();
				System.out.println("PipeLineId : "+pipeLineId);
				int userProfileId=model.getUserProfileId();
				System.out.println("UserProfileId : "+userProfileId);
				int personId=perValue;
				System.out.println("PersonId : "+personId);
				int organizationId=orgValue;
				System.out.println("OrganizationId : "+organizationId);
				boolean active=model.getActive();
				System.out.println("Active : "+active);
				int visibleTo=model.getVisibleTo();
				System.out.println("VisibleTo : "+visibleTo);
				String expectedCloseDate=model.getExpectedCloseDate();
				System.out.println("ExpectedClosedDate : "+expectedCloseDate);
				String personName=model.getPersonName();
				System.out.println("PersonName : "+personName);
				String orgName=model.getOrgName();
				System.out.println("OrgName : "+orgName);
				String ownerName=model.getOwnerName();
				System.out.println("OwnerName : "+ownerName);
				
				
				
				try{
					String query="{CALL `Company.Deal_PipeInsertDeal`(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					System.out.println("Query : "+query);
					connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
					callableStatement=connection.prepareCall(query);
					callableStatement.setString(1, title);
					callableStatement.setInt(2, value);
					callableStatement.setString(3, currency);
					callableStatement.setInt(4,stageId);
					callableStatement.setInt(5, pipeLineId);
					callableStatement.setInt(6, userProfileId);
					callableStatement.setInt(7, personId);
					callableStatement.setInt(8, organizationId);
					callableStatement.setBoolean(9, active);
					callableStatement.setInt(10, visibleTo);
					callableStatement.setString(11, expectedCloseDate);
					callableStatement.setString(12, personName);
					callableStatement.setString(13, orgName);
					callableStatement.setString(14, ownerName);
					int count=callableStatement.executeUpdate();
					if(count>0){
						response=GetDealByUserProfileIdClass.getDealByUserProfileId(userProfileId);
					}else{
						response.setIsSuccess(false);
						response.setMessage("Deal is not inserted "+count);
						response.setDealList(null);
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(connection!=null){
						try {
							connection.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
					if(callableStatement!=null){
						try {
							callableStatement.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}
				
			}else{
				response.setIsSuccess(false);
				response.setMessage("Person is not inserted");
				response.setDealList(null);
			}
			
			
		}else{
			response.setIsSuccess(false);
			response.setMessage("Organization is not inserted");
			response.setDealList(null);
		}
		
		
		
		return response;
	}

private static int insertOrganization(OrganizationModel model){
	int finalvalue=0;
	Connection connection=null;
	Statement st=null;
	try{
		String name=model.getName();
		name="'"+name+"'";
		int peopleCount=model.getPeopleCount();
		int openDeals=model.getOpenDealsCount();
		String ownerName=model.getOwnerName();
		ownerName="'"+ownerName+"'";
		int visibleTo=model.getVisibleTo();
		int userProfileId=model.getOwnersUserProfileId();
		String companyCode=model.getCompanyCode();
		companyCode="'"+companyCode+"'";
		boolean activeFlag=model.getActiveFlag();
		String query="CALL `Company.Organization_PipeInsertDeal_Org`("+name+","+peopleCount+","+userProfileId+","+companyCode+","+openDeals+","+activeFlag+","+visibleTo+","+ownerName+")";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			finalvalue=rs.getInt(OrganizationDBConstants.LAST_INSERT_ID);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection!=null){
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	return finalvalue;
}
private static int insertPerson(PersonModel model){
	int finalvalue=0;
	Connection connection=null;
	Statement st=null;
	try{
		String name=model.getName();
		name="'"+name+"'";
		String organizationName=model.getOrgName();
		organizationName="'"+organizationName+"'";
		int openDeals=model.getOpenDealsCount();
		String ownerName=model.getOwnerName();
		ownerName="'"+ownerName+"'";
		int visibleTo=model.getVisibleTo();
		String companyCode=model.getCompanyCode();
		companyCode="'"+companyCode+"'";
		int userProfileId=model.getUserProfileId();
		int organizationId=model.getOrgId();
		boolean activeFlag=model.getActiveFlag();
		String query="CALL `UserSettings.Person_PipeInsertDeal_Person` ("+name+","+userProfileId+","+companyCode+","+organizationId+","+openDeals+","+visibleTo+","+organizationName+","+ownerName+","+activeFlag+")";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			finalvalue=rs.getInt(OrganizationDBConstants.LAST_INSERT_ID);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection!=null){
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	return finalvalue;
}
}
