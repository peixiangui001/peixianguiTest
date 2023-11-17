package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.po.A;
import org.example.util.AutoFill;
import org.example.util.OperationType;

@Mapper
public interface TestMapper {


    @AutoFill(OperationType.INSERT)
    void saveA(A a);


    @AutoFill(OperationType.UPDATE)
    void update(A a);
}
