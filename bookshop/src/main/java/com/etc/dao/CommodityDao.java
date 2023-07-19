package com.etc.dao;

import com.etc.pojo.Commodity;
import com.etc.vo.BlogsCharts;
import com.etc.vo.BookCharts;
import com.etc.vo.CommodityVO;

import java.util.List;

/**
 * @author zwh
 * @date 2021/11/18
 * 商品类数据访问接口
 */
public interface CommodityDao {

    /**
     * 查询所有商品
     * @return  商品对象集合
     */
    public List<CommodityVO> findAll();


    /**
     * 根据一级分类编号查询商品
     * @param sortIdOne 一级分类编号
     * @param companyStats 状态编号
     * @return 商品对象集合
     */
    public List<CommodityVO> findBySortIdOne(int sortIdOne,int companyStats);


    /**
     * 根据二级分类编号查询商品
     * @param sortIdTwo 二级分类编号
     * @param companyStats 状态编号
     * @return 商品对象集合
     */
    public List<CommodityVO> findBySortIdTwo(int sortIdTwo,int companyStats);

    /**
     * 根据三级分类编号查询商品
     * @param sortIdThree 三级分类编号
     * @param companyStats 状态编号
     * @return 商品对象集合
     */
    public List<CommodityVO> findBySortIdThree(int sortIdThree,int companyStats);

    /**
     * 根据商品编号查询商品
     * @param commodityId  商品编号
     * @return 商品对象
     */
    public CommodityVO findByCommodityId(int commodityId);

    /**
     * 根据商品状态查询
     * @param companyStats 商品状态编号
     * @return 商品对象集合
     */
    public List<CommodityVO> findByCompanyStats(int companyStats);

    /**
     * 添加商品
     * @param commodity 商品对象
     * @return 受影响行数
     */
    public int add(Commodity commodity);

    /**
     * 更新商品
     * @param commodity 商品对象
     * @return 受影响行数
     */
    public int update(Commodity commodity);

    /**
     * 查询商品统计
     *
     * @return 帖子统计对象集合
     */
    public List<BookCharts> findStat();
}
