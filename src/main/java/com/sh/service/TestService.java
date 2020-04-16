package com.sh.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TestService {

    String getTest(String str);

}
