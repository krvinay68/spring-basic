# spring-basic
-------------------
Spring provides three types of configuration to manage the beans or object:-
1.XML based configuration
2.Annotation based configuration
3.java based configuration

# Steps for java based configuration:-
----------------------------------
1.Create configuration class with @Configuration annotation
2.Create method and annotated it with @Bean annotation
3.Create Spring IOC Container(ApplicationContext) and retrive Spring bean from spring IoC container.
   ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

# Steps for Annotation based configuration:-
----------------------------------------------
1.Annotated a class with @Component annotation
2.Use @ComponentScan annotation to specify package name for scanning those classes that are annotated with @Component annotation
3.Use @Autowired annotation to automatically inject the Spring bean
4.Use @Qualifier annotation to avoid the confusion between multiple spring beans of the same type.
5.Create Spring Ioc Container (ApplicationContext) and retrive spring bean from spring Ioc container.
    ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
    
@Primary Annotation:-We use @Primary annotation to give higher preference to a bean when there are multiple beans of the same type.
@Bean annotaion:-indicates that a method produces a bean to be managed by the spring container.The @Bean annotation is usually declared in configuration class to create spring bean definitions.
-by default,the bean name is same as method name.we can specify bean name using @Bean(name="beanName").
-@Bean annotation provides initMethod and destroyMethod attributes to perform certain actions after bean initialization or before bean destruction by a container.
-----------------------------------
# Steps for XML based configuration:-


----------------------------------
# Spring IoC Container Types:-

1.BeanFactory container: Responsible for creating the beans, configuring the beans and managing the bean's entire life cycle.and it is 
  basic container.

2.ApplicationContext container:-
  ->Responsible for creating the beans, configuring the beans and managing the bean's entire life cycle.
  ->Support Enterprise Application Features:-  
     -It provides messaging functionality.
	   -Envent publication functionality.
	   -Annotation based dependency injection.
	   -Easy integration with spirng AOP features.
	   -Supports almost all types of bean scoeps.

# Stereotype annotaions:-

                        @Component
                            |
                            |
          -------------------------------------------
         |                  |                       |
         |                  |                       |
         |                  |                       |
    @Controller          @Service               @Repository  
 [controller           [Service classes       [Repository Classes in DAO layer]  
  classes in            in service layer] 
  controller
  layer]  
  
 1.These annotaions are used to create spring beans automatically in the application context(ioc container).
 2.The main stereotype annotaion is @Component
 3.By using this annotaion,Spring provides more stereotype meta annotaions such as @Service,@Repository and  
   @Controller
 4.@Service annotaion is used to create spring beans at the service layer
 5.@Repository is used to create spring beans for the repositores at the DAO layer
 6.@Controller is used to create spring beans at the controller layer.
 

# Dependency Injection:-
1.Dependency injection is a design pattern on which dependency of the object is injected by the framework rather than created by Object iteself - it is also called IOC(Inversion of control).
2.Dependency injection reduces coupling between multiple objects as its dynamically injected by the framework.
3.Spring IoC container uses DI to inject one object into another object.
4.There are maninly three types of dependency injection:
    Contructor Injection,Setter Injection and Field Injection.
    
Dependency:-An object usually requires objects of other classes to perform its operations.We call these objects dependencies.
Injection:-The process of providing the required dependencies to an object.

Constructor Based Dependency Injection:-
->Constructor injection uses the contructor to inject dependency on any Spring-managed bean.
->Before Spring 4.3,we had to add an @Autowired annotation to the constructor.With newer versions,this is optional if the class only one constructor.
->When we have a class with multiple constructors, we need to explicitly add the @Autowired annotaion to any one of the constructors so that spring knows which constructor to use to inject the dependencies.

Setter Based Dependency Injection:-
->Setter injection uses the setter method to inject dependency on any spring-managed bean.
->We have to annotate the setter method with the @Autowired annotaion.
->Spring will find the @Autowired annotation and call the setter to inject the dependency.

Field Based Dependency Injection:-
->As the name says the dependency is injected dierectly in the field,with no constructor or setter needed.This is done by annotating the class member with the @Autowired annotaion.
->Spring Container uses reflection to inject the dependencies,which is costler than constructor based or setter based injection.

Field Based Dependency Injection Drawbacks:-
->We cannot create immutable dependency object,as we can with constructor injection(we can't make field final).
->Our classes have tight coupling with spring ioc container and cannot be used outside of it.
->our classes cannot be instantiated without reflection.we need the spring ioc container to instantiate them,which makes our tests more like integration tests.
->having too many dependencies is a red flag that the class usually does more than one thing,and that it may violate the single responsibility principle.

When to use Constructor and Setter Based Dependency Injection?:-
->use constructor based DI for mandatory dependencies so that our bean is ready to use when it is first time called.
->Use setter based DI only for optional dependencies.
->Use setter injection to avoid circular dependencies.

Which one is recommended Constructor or Setter Based dependency injection:-
Spring team recommended to use constructor based dependency injection.
->All requried dependencies are available at initialization time(this reduces the code as well)
->Immutability and avoid NullPointerException
->Preventing errors in Tests.

***********************************************************************
