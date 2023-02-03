package dbsecure;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration
@EnableEncryptableProperties	// 현재 정보를 application.properties 파일에서 사용 가능
public class DBConfig {
	
	@Bean(name = "jasyptEncryptor")
	public StringEncryptor stringEncriptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(System.getenv("DB_PASSWORD"));
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        
        System.out.println("===== DBConfig 출력 =====");
        System.out.println(System.getenv("DB_PASSWORD"));
        System.out.println(encryptor.decrypt("atW4+WT1VmOgPlaHkT5NXrGdrW4wA0iQNbOhpjQeB1M="));
        System.out.println(encryptor.decrypt(
        		"UObombg0mDutowrVlE0EO0JctjEn3ouqWQ/0AA+vNhokWie3vXkPkiLvw9bWgn1/t5evcC2Tx1E7saBUOTAmzGk6ALfp+H6ZBHiD5FzvXyi9cj+jn5J4yQ4vCpAVlamUW/DMNewNmYE="
        		));
        System.out.println(encryptor.decrypt("Gb11UpKkxKbVUBn+G54AItHWeI58Z6qu"));
        System.out.println(encryptor.decrypt("FAWgAyF/ShL8QW3gDU6uIxyExmAe9tYU"));
        
		return encryptor;
	}
}
