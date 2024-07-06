package com.conference.management.repository;

import com.conference.management.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PaperRepository implements IPaperRepository{

    private EntityManager entityManager;

    @Autowired
    public PaperRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Paper paper) {
        entityManager.persist(paper);
    }

    @Override
    public Paper getById(int id) {
        Paper paper=entityManager.find(Paper.class, id);
        return paper;
    }

    @Override
    public List<Paper> getByReviewer(int id){
        TypedQuery<Paper> query=entityManager.createQuery("SELECT p FROM Paper p " +
                "JOIN p.paper_assignments a " +
                "WHERE a.reviewer.id =:data", Paper.class);
        query.setParameter("data", id);
        List<Paper> papers=query.getResultList();
        return papers;
    }

    @Override
    public List<Paper> getByAuthor(int id) {
        TypedQuery<Paper> query=entityManager.createQuery("SELECT p FROM Paper p WHERE p.author.id =:data", Paper.class);
        query.setParameter("data", id);
        List<Paper> papers=query.getResultList();
        return papers;
    }

    @Override
    public List<Paper> getAllApprovedPapers() {
        TypedQuery<Paper> query=entityManager.createQuery("SELECT p FROM Paper p " +
                "JOIN p.paper_assignments pa " +
                "WHERE pa.result =:data ", Paper.class);
        query.setParameter("data","Onaylandı.");
        List<Paper> papers=query.getResultList();
        return papers;
    }

    @Override
    public List<Paper> getAll() {
        TypedQuery<Paper> query=entityManager.createQuery("select p from Paper p", Paper.class);
        List<Paper> paperList=query.getResultList();
        return paperList;
    }

    @Override
    public List<Paper> getPapersByField(String field) {
        TypedQuery<Paper> query = entityManager.createQuery(
                "select p " +
                        "from Paper p " +
                        "WHERE p.state = :paperState " +
                        "AND p.paper_field = :paperField", Paper.class);
        query.setParameter("paperField", field);
        query.setParameter("paperState", "Atama Bekliyor.");
        List<Paper> paperList = query.getResultList();
        return paperList;
    }

    @Transactional
    @Override
    public void update(Paper paper) {
        if(paper!=null){
            deleteAssociatedEntities(paper);
        }
        System.out.println(paper.getKeywords().get(0).getKeyword());
        entityManager.flush();
        entityManager.clear();
        entityManager.merge(paper);
    }


    public void deleteAssociatedEntities(Paper paper) {
        // PaperFile nesnelerini sil
        String queryString = "DELETE FROM PaperFile WHERE file_owner_paper.id = :paperId";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("paperId", paper.getId());
        query.executeUpdate();

        // Keyword nesnelerini sil
        String queryString2 = "DELETE FROM Keyword WHERE paper.id = :paperId";
        Query query2 = entityManager.createQuery(queryString2);
        query2.setParameter("paperId", paper.getId());
        query2.executeUpdate();

        // Source nesnelerini sil
        String queryString3 = "DELETE FROM Source WHERE paper.id = :paperId";
        Query query3 = entityManager.createQuery(queryString3);
        query3.setParameter("paperId", paper.getId());
        query3.executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        Paper paper=getById(id);
        if(paper!=null){

            paper.getPaper_files().clear();
            paper.getPaper_assignments().clear();
            paper.getKeywords().clear();
            paper.getSources().clear();

            String queryString = "DELETE FROM PaperFile WHERE file_owner_paper.id = :paperId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("paperId", paper.getId());
            query.executeUpdate();

            String queryString2 = "DELETE FROM Keyword WHERE paper.id = :paperId";
            Query query2 = entityManager.createQuery(queryString2);
            query2.setParameter("paperId", paper.getId());
            query2.executeUpdate();

            String queryString3 = "DELETE FROM Source WHERE paper.id = :paperId";
            Query query3 = entityManager.createQuery(queryString3);
            query3.setParameter("paperId", paper.getId());
            query3.executeUpdate();

            String queryString4 = "DELETE FROM PaperAssignment WHERE paper.id = :paperId";
            Query query4 = entityManager.createQuery(queryString4);
            query4.setParameter("paperId", paper.getId());
            query4.executeUpdate();

        }
        entityManager.remove(paper);
    }
}
