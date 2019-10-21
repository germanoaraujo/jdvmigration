package com.redhat.JDVSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JdvSpringBootApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    String sql = "SELECT * FROM PessoaCanonical.Pessoa";

	public static void main(String[] args) {
		SpringApplication.run(JdvSpringBootApplication.class, args).close();
	}

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.query(sql, new Pessoa());
    }
}