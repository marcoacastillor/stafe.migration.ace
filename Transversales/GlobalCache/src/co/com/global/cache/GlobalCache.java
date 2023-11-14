package co.com.global.cache;

import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbGlobalMap;
import com.ibm.broker.plugin.MbGlobalMapSessionPolicy;

public class GlobalCache extends MbGlobalMap
{
	protected GlobalCache() throws MbException 
	{
		super();
	}

	public static String put(String key, String value, String nameCache)
	{
		try 
		{
			MbGlobalMapSessionPolicy sessionPol = new MbGlobalMapSessionPolicy(36000);
			return (String)MbGlobalMap.getGlobalMap(nameCache,sessionPol).put(key, value);
		} catch (Exception e) 
		{
			return e.getMessage().toString();
		}
		
	}
	
	public static String get(String key, String nameCache)
	{
		try 
		{
			return (String)MbGlobalMap.getGlobalMap(nameCache).get(key);
		} catch (Exception e) {
			return e.getMessage().toString();
		}
	}

	public static String remove(String key, String nameCache) 
	{
		try 
		{
			String tmp = (String)MbGlobalMap.getGlobalMap(nameCache).remove(key); 
			return tmp;
		} catch (Exception e) 
		{
			return e.getMessage().toString();
		}
	}
}
