package net.yst.dao;

import java.util.List;
import net.yst.models.IdNo;
import net.yst.models.IdNoExample;
import org.apache.ibatis.annotations.Param;

public interface IdNoMapper {
    int countByExample(IdNoExample example);

    int deleteByExample(IdNoExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(IdNo record);

    int insertSelective(IdNo record);

    List<IdNo> selectByExample(IdNoExample example);

    IdNo selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") IdNo record, @Param("example") IdNoExample example);

    int updateByExample(@Param("record") IdNo record, @Param("example") IdNoExample example);

    int updateByPrimaryKeySelective(IdNo record);

    int updateByPrimaryKey(IdNo record);
}