package com.example.SampleJPAREST.repository;
import com.example.SampleJPAREST.entities.Samples;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
@EnableAutoConfiguration
public interface SampleRepo extends JpaRepository<Samples,Integer>
{

}
