package cn.edu.zhku.hyw.watchworld.customer.JavaBean;

/**
 * 此类为数据库表activity的映射
 * @author 曾裕文
 *
 */
public class Activity
{
	private String ActivityPicturePath;
	private int StoreId;

	public String getActivityPicturePath()
	{
		return ActivityPicturePath;
	}

	public void setActivityPicturePath(String activityPicturePath)
	{
		ActivityPicturePath = activityPicturePath;
	}

	public int getStoreId()
	{
		return StoreId;
	}

	public void setStoreId(int storeId)
	{
		StoreId = storeId;
	}
}
