package medicinetrackerapplication;
public class User {
static String email,name,mob;
static String Longitude;
static String RTitle;
static String Latitude;
public static String getEmail()
{
	return email;
}
public static void setEmail(String email)
{
	User.email=email;
}
public static String getName()
{
	return name;
}
public static void setName(String name)
{
	User.name=name;
}

public static String getRTitle()
{
	return RTitle;
}
public static void setRTitle(String RTitle)
{
	User.RTitle=RTitle;
}
public static String getLatitude()
{
	return Latitude;
}
public static void setLatitude(String lat)
{
	User.Latitude=lat;
	
}
public static String getLongitude()
{
	return Longitude;
}
public static void setLongitude(String lng)
{
	User.Longitude=lng;
}
public static void main(String args[])
{
		
}
}
