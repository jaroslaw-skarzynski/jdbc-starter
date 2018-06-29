package pl.sda.jpa.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.jpa.starter.related_entities.AddressEntity;
import pl.sda.jpa.starter.related_entities.CourseEntity;
import pl.sda.jpa.starter.related_entities.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaRelations {
    private static Logger logger = LoggerFactory.getLogger(JpaRelations.class);
    private EntityManagerFactory entityManagerFactory;

    public void createEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pl.sda.jpa.starter");
    }

    public void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

    public static void main(String[] args) {
        JpaRelations jpaQueries = new JpaRelations();
        try {
            jpaQueries.createEntityManagerFactory();
            jpaQueries.oneToOne();
            //jpaQueries.oneToMany();
            //jpaQueries.manyToMany();
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            jpaQueries.closeEntityManagerFactory();
        }
    }

    private void oneToOne() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            AddressEntity address = new AddressEntity("Gdańsk", "Malwinowa 1/3");
            StudentEntity student = new StudentEntity("Jan Kowalski");
            //student.setAddress(address);

            //entityManager.persist(address);
            //entityManager.persist(student);

            //StudentEntity studentEntity = entityManager.find(StudentEntity.class, 1);
            //logger.info("Student: {}", studentEntity);

           // AddressEntity addressEntity = entityManager.find(AddressEntity.class, 1);
            //logger.info("AddressEntity Student: {}", addressEntity.getStudent());

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    private void oneToMany() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            CourseEntity course = new CourseEntity("JavaGda11", "Sopot");
            StudentEntity student = new StudentEntity("Jan Kowalski");
            //student.setCourse(course);

            //entityManager.persist(course);
            entityManager.persist(student);

            /*StudentEntity studentEntity = entityManager.find(StudentEntity.class, 1);
            logger.info("Student: {}", studentEntity);*/

            /*CourseEntity courseEntity = entityManager.find(CourseEntity.class, 1);
            logger.info("Course: {}", courseEntity);*/

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    private void manyToMany() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            /*SkillEntity skill1 = new SkillEntity("JVM Master");
            SkillEntity skill2 = new SkillEntity("JDBC Master");
            SkillEntity skill3 = new SkillEntity("Hibernate Master");
            StudentEntity student = new StudentEntity("Jan Kowalski");
            student.addSkill(skill1);
            student.addSkill(skill2);
            student.addSkill(skill3);*/
            //entityManager.persist(student);

            //StudentEntity studentEntity = entityManager.find(StudentEntity.class, 1);
            //logger.info("Student: {}", studentEntity);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}