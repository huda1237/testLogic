# Service

Created Service using `Spring Boot Version 3.1.6` and using `Java 17`.


## Depedencies : 
- spring-boot-starter-data-jdbc
- postgresql
- commons-lang
- lombok
- spring-boot-starter-cache
- spring-boot-starter-data-redis
- jedis

## Directory Structure
- api

To configure other services using open feign.

- config

Works to configure with databases, accommodate database queries.

- controller

As the system controller. The controller also declares the endpoints that exist in the system.

- dto

To communicate with the database, such as entering and reading data.

- exception

Used to handle exceptions in the system.


- util

To accommodate the required functions.

**Service, Developer**



# Service
## Spring IoC

  
 - code for ioc annotation:
 ```java
@Configuration
@EnableCaching
public class CacheConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    # To connect into radist.
    @Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host);
        configuration.setPort(port);
//        configuration.setPassword("admin123");
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(configuration);
        return jedisConnectionFactory;
    }

    # Required Redis template components.
    @Bean
    public RedisTemplate<String, Object> template() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory());
        redisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}

```


## Java Stream

  
  - code for Stream:
  location file co.id.test.sales.StreamTest.java


  ```java
        @SpringBootTest
        public class StreamTest {
            @Autowired
            private BasketDao dao;
            @Test
            void contextLoads() {
                List< BasketEntity > data = dao.findAll();
                data.stream().forEach( x ->
                        System.out.println(x.toString())
                );
            }
        }
  
  ```


  - Result
  ![image](https://github.com/huda1237/testLogic/assets/65228809/0d2bb1fc-1939-4d03-b883-d2d42d94c6aa)



  ## Advance Native SQL query

  - query that has been implemented in JDBC

  
  ```sql
        SELECT a.product_id, a.product_name, a.price, b.group_name ,
        b.description as description_group 
        FROM sales.products a join sales.product_groups b on a.group_id = b.group_id
        where a.product_id = 1 ;
  
  ```


  - queries that are not implemented in JDBC

  ```sql
      SELECT 
    	SUM (a.price)::NUMERIC(10,2) as priceA
      FROM sales.products a join sales.product_groups b on a.group_id = b.group_id  ;

  ```

  - Code on aplication
    ```java
           @Override
      public <T> List<T> getAll(Class<T> tClass) {
          log.debug("Prepare query to data base ");
          try {
              String query = QueryConstant.SELECT_PRODUCT_ALL;
              List<T> queryExecute = (List<T>)jdbcTemplate.query(
                      query,
                      new BeanPropertyRowMapper<>(tClass)
              );
              return queryExecute;
          }catch (Exception e){
              log.error(e.getMessage());
          }
          throw new ResponseErrorException(
                  HttpConstant.BADR_CODE,
                  HttpConstant.MESSAGE_BDR,
                  HttpStatus.BAD_REQUEST
          );
      }
    
    ```

    ```java
          @Override
      public <T> T insert(Object[] data , Class<T> tClass) {
          log.debug("Prepare save to data base ");
          TransactionDefinition def = new DefaultTransactionDefinition();
          TransactionStatus status = transactionManager.getTransaction(def);
          try {
              String query = QueryConstant.INSERT_PRODUCT;
              T queryExecute = jdbcTemplate.queryForObject(
                      query,
                      data,
                      new BeanPropertyRowMapper<>(tClass)
              );
              transactionManager.commit(status);
              return queryExecute;
          }catch (Exception e){
              log.error(e.getMessage());
          }
          transactionManager.rollback(status);
          throw new ResponseErrorException(
                  HttpConstant.BADR_CODE,
                  HttpConstant.MESSAGE_BDR,
                  HttpStatus.BAD_REQUEST
          );
      }
    
    ```
  - Result
    ![image](https://github.com/huda1237/testLogic/assets/65228809/269e6810-bf53-4871-908e-9cbec04769f7)

    ![image](https://github.com/huda1237/testLogic/assets/65228809/27024e7f-2b0f-44ca-857a-ea8bf05e6338)

  ## Containerization & microservices
  - Docker-compose.yml

    ```yaml
      version: '3'
      services: 
         bcad-demo:
           build:
             context: .
             dockerfile: ./Dockerfile
           restart: always
           container_name: service
           volumes:
            - type: bind
              source: /var/www/api/service
              target: /data
         
      
           ports:
             - "8083:8083"
           networks:
            - service
        
      networks:
        service:
            driver: bridge
    ```
   - Dockerfile
      ```
      FROM adoptopenjdk/openjdk17:alpine-jre

      EXPOSE 8083
      COPY target/sales-0.0.1-SNAPSHOT.jar sales-0.0.1-SNAPSHOT.jar
      ENTRYPOINT ["java","-jar","/sales-0.0.1-SNAPSHOT.jar"]
      ```
   - RestTemplate
    
      ```java
       ResponseEntity<?> response = restTemplate.exchange("http://localhost:8000/xxx", HttpMethod.POST, req, Map.class);
      ```


  ## Kafka & Stream Based Application
  ## Redis, Caching Strategy & Data Grid
  - Caching & redis
    
      ```java
        @Autowired
        private RedisTemplate template;
        @Cacheable(value = "detail-basket", key = "#id")
        public BasketEntity findProductById(long id){
            return (BasketEntity) template.opsForHash().get(HASH_KEY,id);
        }
      ```
  
  ## Elastic & Other Non Relational DB
      
