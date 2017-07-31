package org.ebl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationExample;
import org.ebl.mapper.CorporationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EblApplicationTests {

	@Autowired
	private CorporationMapper corporationMapper;

	@Test
	public void contextLoads() {
		PageHelper.startPage(1,1);
		CorporationExample example = new CorporationExample();
		Page<Corporation> obj = (Page<Corporation>)this.corporationMapper.selectByExample(example);
		System.err.println(obj.getTotal());
	}

}
