package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumenttype;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DocumentsDocumenttypeRepository implements JpaRepository<DocumentsDocumenttype, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends DocumentsDocumenttype> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsDocumenttype> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DocumentsDocumenttype> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DocumentsDocumenttype getOne(Long aLong) {
        return null;
    }

    @Override
    public DocumentsDocumenttype getById(Long aLong) {
        return null;
    }

    @Override
    public DocumentsDocumenttype getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends DocumentsDocumenttype> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DocumentsDocumenttype> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DocumentsDocumenttype> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DocumentsDocumenttype> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DocumentsDocumenttype> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DocumentsDocumenttype> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends DocumentsDocumenttype, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends DocumentsDocumenttype> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsDocumenttype> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DocumentsDocumenttype> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<DocumentsDocumenttype> findAll() {
        return null;
    }

    @Override
    public List<DocumentsDocumenttype> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(DocumentsDocumenttype entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends DocumentsDocumenttype> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<DocumentsDocumenttype> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DocumentsDocumenttype> findAll(Pageable pageable) {
        return null;
    }
}
