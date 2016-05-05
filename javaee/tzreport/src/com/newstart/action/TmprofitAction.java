package com.newstart.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.newstart.dao.ProfitDao;
import com.newstart.dao.ProfitStatDao;
import com.newstart.entity.ProfitBean;

/**
 * 
 * 类名: TmprofitAction
 * 描述: 收入的处理业务类。
 * 创建人: zhoujuan
 * 时间: 2016年4月17日 下午2:16:18
 * @version: V1.0
 */
public class TmprofitAction extends BaseAction{
    private List<ProfitBean> profitBeans;
    private ProfitBean profitBean;
    private Integer id;
    private int isDelete;
    private String result;
    private List<HashMap<String,Object>> maps;
    private Integer PageNo=0;
    private Integer PageSize=5;
    private Integer typeId;
    private Integer minMoney;
    private Integer maxMoney;
    public String execute(){
    	return "error";
    }
	//查询收入处理，保存在作用域中，然后在跳转到的jsp页面中获取。
    public String list(){
    	result = String.valueOf(ProfitDao.countProfit(typeId,maxMoney,minMoney));
    	maps = ProfitDao.findProfitTypes();
		profitBeans = ProfitDao.findProfits(typeId,maxMoney,minMoney,PageNo,PageSize);
		return "success";
	}
    /**
     * 
     * 方法名: listTemplate
     * 描述: 加载模板数据。
     * 创建人: zhoujuan
     * 时间: 2016年4月23日 下午5:39:20
     * @return
     * @return: String
     * @since: V1.0
     */
    public String listTemplate(){
    	result = String.valueOf(ProfitDao.countProfit(typeId,maxMoney,minMoney));    	
    	profitBeans = ProfitDao.findProfits(typeId,maxMoney,minMoney,PageNo,PageSize);
    	return "success";
    }
    //添加收入
    public String add(){        
    	maps = ProfitDao.findProfitTypes();
    	if(id!=null){
    		profitBean = ProfitDao.getProfitBean(id);
    	}
    	return "success";
    }
    //添加收入
    public String save(){
    	profitBean.setStatus(1);
    	profitBean.setIsDelete(0);
		boolean flag = ProfitDao.saveProfit(profitBean);    	
        if(flag){
        	result="success";
        }else{
        	result="fail";
        }
    	return "Ajaxsuccess";
    }
    
    public String update(){
    	//修改数据保存到数据库中
    	boolean flag = ProfitDao.updateProfit(profitBean);
        if(flag){
        	result="success";
        }else{
        	result="fail";
        }
    	return "Ajaxsuccess";    	
    }
    /**
     * 
     * 方法名: delete
     * 描述: 删除收入记录
     * 创建人: zhoujuan
     * 时间: 2016年4月18日 上午9:57:41
     * @return
     * @return: String
     * @since: V1.0
     */
    public String delete(){
        boolean flag = ProfitDao.updateProfit(1, id);
        if(flag){
           result = "success";
           return "Ajaxsuccess";
        }
        result = "fail";
        return "error";
    }
    /**
     * 
     * 方法名: back
     * 描述: 还原收入记录。
     * 创建人: zhoujuan
     * 时间: 2016年4月18日 上午9:58:15
     * @return
     * @return: String
     * @since: V1.0
     */
    public String back(){
    	boolean flag = ProfitDao.updateProfit(0, id);
    	if(flag){
    		result = "success";
    		return "Ajaxsuccess";
    	}
    	result = "fail";
    	return "error";                             
    }
    
    /**
     * 
     * 方法名: detail
     * 描述: 统计收入报表。
     * 创建人: zhoujuan
     * 时间: 2016年4月25日 下午8:59:07
     * @return
     * @return: String
     * @since: V1.0
     */
    public String detail(){
    	maps = ProfitDao.findProfitTypes();
    	return "success";
    }
    
    /**
     * 
     * 方法名: detailAjax
     * 描述: 查询今天的收入明细。
     * 创建人: zhoujuan
     * 时间: 2016年4月27日 下午5:19:57
     * @return
     * @return: String
     * @since: V1.0
     */
    public String detailAjax(){
    	profitBeans = ProfitStatDao.findDetailProfits();
    	return "Ajaxsuccess";
    }
    
    /**
     * 
     * 方法名: detailYear
     * 描述: 查询本年的收入明细。
     * 创建人: zhoujuan
     * 时间: 2016年4月27日 下午5:20:21
     * @return
     * @return: String
     * @since: V1.0
     */
    public String detailYear(){
		HashMap<Integer,Object> map = ProfitStatDao.findProfitsByYear();
		TreeMap<Integer,Object> treeMap = new TreeMap<Integer,Object>();
		for(int i=1; i<=12; i++){
		    Object value = map.get(i);
		    treeMap.put(i,value==null?0:value);
		}
		try {
			result = JSONUtil.serialize(treeMap);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return AJAXSUCCESS;
    }

    public String  detailType(){
    	HashMap<String,Object> hashMap = ProfitStatDao.findProfitsByType();
	    HashMap<String,Object> map =new HashMap<String,Object>();
	    for(Map.Entry<String, Object> entry: hashMap.entrySet()){
	    	//System.out.println(entry.getKey()+"==="+entry.getValue());
	    	String[] keys = entry.getKey().split("_");
	    	//获取key的月份
	    	int month = Integer.parseInt(keys[0]);
	    	//获取类型
	    	String type = keys[1];
	    	if(map.get(type)==null){	    		
	    		//定义一个map补齐月份
	    		List<HashMap<Integer,Object>> maps = new ArrayList<HashMap<Integer,Object>>();
	    		HashMap<Integer,Object> mmap = null;
	    		for(int i=1;i<=12;i++){
	    			mmap = new HashMap<Integer,Object>();
	    			Object value = hashMap.get(i+"_"+type);
	    			mmap.put(i,value==null ? 0:value);
	    			maps.add(mmap);
	    		}
	    		map.put(type,maps);
	    	}
	    }
	    try {
			result = JSONUtil.serialize(map);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return AJAXSUCCESS;
    }
    public List<ProfitBean> getProfitBeans() {
		return profitBeans;
	}

	public void setProfitBeans(List<ProfitBean> profitBeans) {
		this.profitBeans = profitBeans;
	}
    	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public List<HashMap<String, Object>> getMaps() {
		return maps;
	}
	
	public void setMaps(List<HashMap<String, Object>> maps) {
		this.maps = maps;
	}

	public ProfitBean getProfitBean() {
		return profitBean;
	}

	public void setProfitBean(ProfitBean profitBean) {
		this.profitBean = profitBean;
	}

	public Integer getPageNo() {
		return PageNo;
	}

	public void setPageNo(Integer pageNo) {
		PageNo = pageNo;
	}

	public Integer getPageSize() {
		return PageSize;
	}

	public void setPageSize(Integer pageSize) {
		PageSize = pageSize;
	}
	
	public Integer getTypeId() {
		return typeId;
	}
	
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getMinMoney() {
		return minMoney;
	}

	public void setMinMoney(Integer minMoney) {
		this.minMoney = minMoney;
	}

	public Integer getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(Integer maxMoney) {
		this.maxMoney = maxMoney;
	}
    
	
}
