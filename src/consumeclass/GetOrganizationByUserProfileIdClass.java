package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.glassfish.hk2.utilities.OrFilter;

import dbconstants.OrganizationDBConstants;
import model.OrganizationModel;
import response.OrganizationResponse;
import utils.Constants;

public class GetOrganizationByUserProfileIdClass {
	private static ArrayList<OrganizationModel>organizationList=new ArrayList<OrganizationModel>();
public static OrganizationResponse getOrganizationByUserProfileId(int UserProfileId){
	OrganizationResponse response=new OrganizationResponse();
	organizationList.clear();
	Connection connection=null;
	Statement statement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="CALL `Company.Organization_GetOrganizationByUserProfileId`("+UserProfileId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		statement=connection.createStatement();
		ResultSet rs=statement.executeQuery(query);
		while(rs.next()){
			OrganizationModel model=new OrganizationModel();
			int organizationId=rs.getInt(OrganizationDBConstants.ORGANIZATION_ID);
			model.setOrganizationId(organizationId);
			String name=rs.getString(OrganizationDBConstants.NAME);
			if(name==null){
				name="";
			}
			model.setName(name);
			int peopleCount=rs.getInt(OrganizationDBConstants.PEOPLE_COUNT);
			model.setPeopleCount(peopleCount);
			int ownersUserProfileId=rs.getInt(OrganizationDBConstants.OWNER_USER_PROFILE_ID);
			model.setOwnersUserProfileId(ownersUserProfileId);
			String address=rs.getString(OrganizationDBConstants.ADDRESS);
			if(address==null){
				address="";
			}
			model.setAddress(address);
			String cCEmail=rs.getString(OrganizationDBConstants.CC_EMAIL);
			if(cCEmail==null){
				cCEmail="";
			}
			model.setCCEmail(cCEmail);
			String createdDate=rs.getString(OrganizationDBConstants.CREATED_DATE);
			if(createdDate==null){
				createdDate="";
			}
			model.setCreatedDate(createdDate);
			String modifiedDate=rs.getString(OrganizationDBConstants.MODIFIED_DATE);
			if(modifiedDate==null){
				modifiedDate="";
			}
			model.setModifiedDate(modifiedDate);
			String companyCode=rs.getString(OrganizationDBConstants.COMPANY_CODE);
			if(companyCode==null){
				companyCode="";
			}
			model.setCompanyCode(companyCode);
			int openDealsCount=rs.getInt(OrganizationDBConstants.OPEN_DEALS_COUNT);
			model.setOpenDealsCount(openDealsCount);
			int relatedOpenDealsCount=rs.getInt(OrganizationDBConstants.RELATED_OPEN_DEALS_COUNT);
			model.setRelatedOpenDealsCount(relatedOpenDealsCount);
			int closedDealsCount=rs.getInt(OrganizationDBConstants.CLOSED_DEALS_COUNT);
			model.setClosedDealsCount(closedDealsCount);
			int relatedClosedDealsCount=rs.getInt(OrganizationDBConstants.RELATED_CLOSED_DEALS_COUNT);
			model.setRelatedClosedDealsCount(relatedClosedDealsCount);
			int emailMessagesCount=rs.getInt(OrganizationDBConstants.EMAIL_MESSAGES_COUNT);
			model.setEmailMessagesCount(emailMessagesCount);
			int activitiesCount=rs.getInt(OrganizationDBConstants.ACTIVITIES_COUNT);
			model.setActivitiesCount(activitiesCount);
			int doneActivitiesCount=rs.getInt(OrganizationDBConstants.DONE_ACTIVITIES_COUNT);
			model.setDoneActivitiesCount(doneActivitiesCount);
			int undoneActivitiesCount=rs.getInt(OrganizationDBConstants.UNDONE_ACTIVITIES_COUNT);
			model.setUndoneActivitiesCount(undoneActivitiesCount);
			int referenceActivitiesCount=rs.getInt(OrganizationDBConstants.REFERENCE_ACTIVITIES_COUNT);
			model.setReferenceActivitiesCount(referenceActivitiesCount);
			int filesCount=rs.getInt(OrganizationDBConstants.FILES_COUNT);
			model.setFilesCount(filesCount);
			int notesCount=rs.getInt(OrganizationDBConstants.NOTES_COUNT);
			model.setNotesCount(notesCount);
			int followersCount=rs.getInt(OrganizationDBConstants.FOLLOWERS_COUNT);
			model.setFollowersCount(followersCount);
			int wonDealsCount=rs.getInt(OrganizationDBConstants.WON_DEALS_COUNT);
			model.setWonDealsCount(wonDealsCount);
			int relatedWonDealsCount=rs.getInt(OrganizationDBConstants.RELATED_WON_DEALS_COUNT);
			model.setRelatedwonDealsCount(relatedWonDealsCount);
			int lostDealsCount=rs.getInt(OrganizationDBConstants.LOST_DEALS_COUNT);
			model.setLostDealsCount(lostDealsCount);
			int relatedLostDealsCount=rs.getInt(OrganizationDBConstants.RELATED_LOST_DEALS_COUNT);
			model.setRelatedLostDealsCount(relatedLostDealsCount);
			boolean activeFlag=rs.getBoolean(OrganizationDBConstants.ACTIVE_FLAG);
			model.setActiveFlag(activeFlag);
			int categoryId=rs.getInt(OrganizationDBConstants.CATEGORY_ID);
			model.setCategoryId(categoryId);
			int pictureId=rs.getInt(OrganizationDBConstants.PICTURE_ID);
			model.setPictureId(pictureId);
			String countryCode=rs.getString(OrganizationDBConstants.COUNTRY_CODE);
			if(countryCode==null){
				countryCode="";
			}
			model.setCountryCode(countryCode);
			String firstChar=rs.getString(OrganizationDBConstants.FIRST_CHAR);
			if(firstChar==null){
				firstChar="";
			}
			model.setFirstChar(firstChar);
			int visibleTo=rs.getInt(OrganizationDBConstants.VISIBLE_TO);
			model.setVisibleTo(visibleTo);
			String nextActivityDate=rs.getString(OrganizationDBConstants.NEXT_ACTIVITY_DATE);
			if(nextActivityDate==null){
				nextActivityDate="";
			}
			model.setNextActivityDate(nextActivityDate);
			String nextActivityTime=rs.getString(OrganizationDBConstants.NEXT_ACTIVITY_TIME);
			if(nextActivityTime==null){
				nextActivityTime="";
			}
			model.setNextActivityTime(nextActivityTime);
			int nextActivityId=rs.getInt(OrganizationDBConstants.NEXT_ACTIVITY_ID);
			model.setNextActivityId(nextActivityId);
			int lastActivityId=rs.getInt(OrganizationDBConstants.LAST_ACTIVITY_ID);
			model.setLastActivityId(lastActivityId);
			String lastActivityDate=rs.getString(OrganizationDBConstants.LAST_ACTIVITY_DATE);
			if(lastActivityDate==null){
				lastActivityDate="";
			}
			model.setLastActivityDate(lastActivityDate);
			String timeLineLastActivityTime=rs.getString(OrganizationDBConstants.TIME_LINE_LAST_ACTIVITY_TIME);
			if(timeLineLastActivityTime==null){
				timeLineLastActivityTime="";
			}
			model.setTimeLineLastActivityTime(timeLineLastActivityTime);
			String timeLineLastActivityTimeByOwner=rs.getString(OrganizationDBConstants.TIME_LINE_LAST_ACTIVITY_TIME_BY_OWNER);
			if(timeLineLastActivityTimeByOwner==null){
				timeLineLastActivityTimeByOwner="";
			}
			model.setTimeLineLastActivityTimeByOwner(timeLineLastActivityTimeByOwner);
			String addressSubpremise=rs.getString(OrganizationDBConstants.ADDRESS_SUBPREMISE);
			if(addressSubpremise==null){
				addressSubpremise="";
			}
			model.setAddressSubpremise(addressSubpremise);
			String addressStreetNumber=rs.getString(OrganizationDBConstants.ADDRESS_STREET_NUMBER);
			if(addressStreetNumber==null){
				addressStreetNumber="";
			}
			model.setAddressStreetNumber(addressStreetNumber);
			String addressRoute=rs.getString(OrganizationDBConstants.ADDRESS_ROUTE);
			if(addressRoute==null){
				addressRoute="";
			}
			model.setAddressRoute(addressRoute);
			String addressSubLocality=rs.getString(OrganizationDBConstants.ADDRESS_SUB_LOCALITY);
			if(addressSubLocality==null){
				addressSubLocality="";
			}
			model.setAddressSubLocality(addressSubLocality);
			String addressLocality=rs.getString(OrganizationDBConstants.ADDRESS_LOCALITY);
			if(addressLocality==null){
				addressLocality="";
			}
			model.setAddressLocality(addressLocality);
			String addressAdminAreaLevel1=rs.getString(OrganizationDBConstants.ADDRESS_ADMIN_AREA_LEVEL1);
			if(addressAdminAreaLevel1==null){
				addressAdminAreaLevel1="";
			}
			model.setAddressAdminAreaLevel1(addressAdminAreaLevel1);
			String addressAdminAreaLevel2=rs.getString(OrganizationDBConstants.ADDRESS_ADMIN_AREA_LEVEL2);
			if(addressAdminAreaLevel2==null){
				addressAdminAreaLevel2="";
			}
			model.setAddressAdminAreaLevel2(addressAdminAreaLevel2);
			String addressCountry=rs.getString(OrganizationDBConstants.ADDRESS_COUNTRY);
			if(addressCountry==null){
				addressCountry="";
			}
			model.setAddressCountry(addressCountry);
			String addressPostalCode=rs.getString(OrganizationDBConstants.ADDRESS_POSTAL_CODE);
			if(addressPostalCode==null){
				addressPostalCode="";
			}
			model.setAddressPostalCode(addressPostalCode);
			String addressFormattedAddress=rs.getString(OrganizationDBConstants.ADDRESS_FORMATTED_ADDRESS);
			if(addressFormattedAddress==null){
				addressFormattedAddress="";
			}
			model.setAddressFormattedAddress(addressFormattedAddress);
			String ownerName=rs.getString(OrganizationDBConstants.OWNER_NAME);
			if(ownerName==null){
				ownerName="";
			}
			model.setOwnerName(ownerName);
			organizationList.add(model);
		}
		if(organizationList!=null&&organizationList.size()!=0){
			   response.setIsSuccess(true);
			   response.setMessage("");
			   response.setOrganizationList(organizationList);
		   }else{
			   response.setIsSuccess(false);
			   response.setMessage("Organization List is Empty or Null!");
			   response.setOrganizationList(null);
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
		if(statement!=null){
			try{
				statement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return response;
}
}
