package com.gyub.driveeodigacar;

import java.sql.Connection;



import javax.inject.Inject;

import javax.sql.DataSource;



import org.junit.Test;

import org.junit.runner.RunWith;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "classpath:spring/dataSource-context.xml" })

public class MysqlConnectionTest {

	private static final Logger logger = LoggerFactory.getLogger(MysqlConnectionTest.class);

	

	@Inject

	private DataSource ds;

	

	@Test

	public void testConnection() {

		try (Connection con = ds.getConnection()){

			logger.info("\n MySQL ���� : " + con);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	}
