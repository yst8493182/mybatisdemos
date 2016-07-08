package net.yst.dao;

import java.util.List;
import net.yst.models.PersonRole;
import net.yst.models.PersonRoleExample;
import org.apache.ibatis.annotations.Param;

public interface PersonRoleMapper {
    int countByExample(PersonRoleExample example);

    int deleteByExample(PersonRoleExample example);

    int insert(PersonRole record);

    int insertSelective(PersonRole record);

    List<PersonRole> selectByExample(PersonRoleExample example);

    int updateByExampleSelective(@Param("record") PersonRole record, @Param("example") PersonRoleExample example);

    int updateByExample(@Param("record") PersonRole record, @Param("example") PersonRoleExample example);
}