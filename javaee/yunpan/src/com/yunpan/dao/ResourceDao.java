package com.yunpan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yunpan.bean.Resource;
import com.yunpan.util.StringUtil;

/**
 * 
 * 类名: ResourceDao
 * 描述: 插入资源文件的数据业务类。
 * 创建人: zhoujuan
 * 时间: 2016年3月12日 下午12:11:02
 * @version: V1.0
 */
public class ResourceDao {	
	/**
	 * 
	 * 方法名: saveResource
	 * 描述: 保存文件信息。
	 * 创建人: zhoujuan
	 * 时间: 2016年3月14日 下午12:06:48
	 * @param resource
	 * @return
	 * @return: boolean
	 * @since: V1.0
	 */
	public static Resource saveResource(Resource resource){
		String sql = "insert into tm_resource(name,size,sizeString,is_delete,status,ext,new_name,user_id,width,height,description,folder_id,url,type)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
    	try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1,resource.getName());
			statement.setInt(2,resource.getSize());
			statement.setString(3,resource.getSizeString());
			statement.setInt(4,resource.getIsDelete());
			statement.setInt(5,resource.getStatus());
			statement.setString(6,resource.getExt());
			statement.setString(7,resource.getNewName());
			statement.setInt(8,resource.getUserId());
			statement.setInt(9,resource.getWidth());
			statement.setInt(10,resource.getHegiht());
			statement.setString(11,resource.getDescription());
			statement.setInt(12,resource.getFolderId());
			statement.setString(13,resource.getUrl());
			statement.setInt(14,resource.getType());
			int count = statement.executeUpdate();
			if(count>0){
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()){
					resource.setId(rs.getInt(1));
				}
				return resource;
			}else{
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
	        ConnectionUtil.closeStatement(statement);
	        ConnectionUtil.closeConnection(connection);
		}
	}
  /**
   *   
   * 方法名: findResources
   * 描述: 查询文件信息返回到页面。
   * 创建人: zhoujuan
   * 时间: 2016年3月14日 上午11:02:24
   * @return
   * @return: List<Resource>
   * @since: V1.0
   */
	public static List<Resource> findResources(Integer type,String keyword,Integer pageNo,Integer pageSize){
		//查询没有删除的文件的信息
	    StringBuilder builder = new StringBuilder();
	    builder.append("select * from tm_resource where is_delete = 0 ");
		if(type!=null){
            builder.append(" and type = "+type+" ");
	    }
		if(StringUtil.isNotEmpty(keyword)){
		    builder.append(" and name like '%"+keyword+"%'");
		}
	    builder.append("order by createtime desc ");
	    builder.append("LIMIT ?,?");
	    String sql = builder.toString();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Resource> resources = null;
    	try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageNo);
			statement.setInt(2, pageSize);
			rs = statement.executeQuery();
			resources= new ArrayList<Resource>();
			Resource resource = null;
			while(rs.next()){
				resource = new Resource();
				resource.setId(rs.getInt("id"));
				resource.setName(rs.getString("name"));
				resource.setSize(rs.getInt("size"));
				resource.setSizeString(rs.getString("sizeString"));
				resource.setCreateTime(rs.getTimestamp("createtime"));
				resource.setIsDelete(rs.getInt("is_delete"));
				resource.setStatus(rs.getInt("status"));
				resource.setExt(rs.getString("ext"));
				resource.setUpdatetime(rs.getTimestamp("updatetime"));
				resource.setNewName(rs.getString("new_name"));
				resource.setUserId(rs.getInt("user_id"));
				resource.setWidth(rs.getInt("width"));
				resource.setHegiht(rs.getInt("height"));
				resource.setDescription(rs.getString("description"));
				resource.setFolderId(rs.getInt("folder_id"));
				resource.setUrl(rs.getString("url"));
				resources.add(resource);
			}
			return resources;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;			
		}finally{
			ConnectionUtil.closeResultSet(rs);
	        ConnectionUtil.closeStatement(statement);
	        ConnectionUtil.closeConnection(connection);
		}		 
	}
	
	/**
	 * 
	 * 方法名: countResources
	 * 描述: 获取要查询数据的总数。
	 * 创建人: zhoujuan
	 * 时间: 2016年3月21日 下午7:42:18
	 * @param type
	 * @return
	 * @return: int
	 * @since: V1.0
	 */
	public static int countResources(Integer type,String keyword){
		//查询没有删除的文件的信息
		StringBuilder builder = new StringBuilder();
		builder.append("select count(1)  from tm_resource where is_delete=0 ");
		if(type!=null){
			builder.append(" and type = "+type+" ");
		}
		if(StringUtil.isNotEmpty(keyword)){
		    builder.append(" and name like '%"+keyword+"%'");
		}		
		String sql = builder.toString();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			int count = 0;
			if(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;			
		}finally{
			ConnectionUtil.closeResultSet(rs);
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);
		}		 
	}
	/**
	 * 
	 * 方法名: deleteResource
	 * 描述: 根据主键id删除文件内容。
	 * 创建人: zhoujuan
	 * 时间: 2016年3月14日 上午11:06:45
	 * @return
	 * @return: boolean
	 * @since: V1.0
	 */
	public static boolean deleteResource(Integer id){
		String sql = "delete from tm_resource where id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
    	try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
            int count = statement.executeUpdate();
            return count>0? true:false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;			
		}finally{
	        ConnectionUtil.closeStatement(statement);
	        ConnectionUtil.closeConnection(connection);
		}				
	}
	
	/**
	 * 
	 * 方法名: updateResource
	 * 描述: 更新文件名
	 * 创建人: zhoujuan
	 * 时间: 2016年3月15日 下午10:29:32
	 * @param id
	 * @return
	 * @return: boolean
	 * @since: V1.0
	 */
	public static boolean updateResource(String name,Integer id){
		String sql = "update tm_resource set name=? where id=?";
		Connection connection = null;
		PreparedStatement statement = null;
    	try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, id);
            int count = statement.executeUpdate();
            return count>0? true:false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;			
		}finally{
	        ConnectionUtil.closeStatement(statement);
	        ConnectionUtil.closeConnection(connection);
		}			
	}
	
	public static boolean deleteResources(String ids){

		String sql = translateSql("tm_resource",ids);
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			//statement.setString(1, ids);
			int count = statement.executeUpdate();
			return count>0? true:false;			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally{
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);
		}
	}
	
	public static String translateSql(String table,String param){
		String sql = "delete from "+table+" where id in(";
		if(StringUtil.isNotEmpty(param)){
			String[]  params = param.split(",");
			for(int i=0;i < params.length;i++){
				if(i==params.length-1){
					sql += params[i];
				}else{
					sql += params[i]+",";
				}
			}
		}
		sql+=")";
		return sql;
	}
	public static void main(String[] args) {
//		Resource resource = new Resource();
//		resource.setDescription("新科技开始");
//		resource.setExt(".jpg");
//		resource.setFolderId(2);
//		resource.setHegiht(300);
//		resource.setIsDelete(0);
//		resource.setName("大师傅");
//		resource.setUrl("http://www.baidu.com");
//		resource.setNewName("logo");
//		resource.setSize(20);
//		resource.setSizeString("MB");
//		resource.setStatus(1);
//		resource.setUserId(3);
//		resource.setWidth(200);
//	    resource.setType(2);
//		saveResource(resource);
		//System.out.println(flag);

		List<Resource> resources = new ArrayList<Resource>();
		resources = findResources(null,"1",0,10);
		for(Resource resource:resources){
			System.out.println(resource.getDescription());
			System.out.println(resource.getExt());
			System.out.println(resource.getName());
			System.out.println(resource.getNewName());
			System.out.println(resource.getSizeString());
			System.out.println(resource.getUrl());
			System.out.println(resource.getCreateTime());
			System.out.println(resource.getFolderId());
			System.out.println(resource.getHegiht());
			System.out.println(resource.getId());
			System.out.println(resource.getIsDelete());
			System.out.println(resource.getSize());
			System.out.println(resource.getStatus());
			System.out.println(resource.getUpdatetime());
			System.out.println(resource.getUserId());			
			System.out.println(resource.getWidth());			
			System.out.println("============================");			
		}
        //删除业务。		
//		boolean flag  = deleteResource(1);
//		System.out.println(flag);
        //修改业务。
//		boolean flag  = updateResource("22222.jpg",74);
//		System.out.println(flag);
		
		//批量删除。
//		boolean flag  = deleteResources("13,14,15");
//		System.out.print(flag);		
		System.out.println(countResources(null,"1"));
	}
}
