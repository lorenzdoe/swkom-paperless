package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocument;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DocumentsDocumentRepository implements JpaRepository<DocumentsDocument, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends DocumentsDocument> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsDocument> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DocumentsDocument> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DocumentsDocument getOne(Long aLong) {
        return null;
    }

    @Override
    public DocumentsDocument getById(Long aLong) {
        return null;
    }

    @Override
    public DocumentsDocument getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends DocumentsDocument> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DocumentsDocument> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DocumentsDocument> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DocumentsDocument> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DocumentsDocument> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DocumentsDocument> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends DocumentsDocument, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends DocumentsDocument> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsDocument> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DocumentsDocument> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<DocumentsDocument> findAll() {
        return null;
    }

    @Override
    public List<DocumentsDocument> findAllById(Iterable<Long> longs) {
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
    public void delete(DocumentsDocument entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends DocumentsDocument> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<DocumentsDocument> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DocumentsDocument> findAll(Pageable pageable) {
        return null;
    }
}
