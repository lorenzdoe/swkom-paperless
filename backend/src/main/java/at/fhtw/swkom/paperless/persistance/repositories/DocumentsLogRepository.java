package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsLog;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DocumentsLogRepository implements JpaRepository<DocumentsLog, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends DocumentsLog> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsLog> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DocumentsLog> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DocumentsLog getOne(Long aLong) {
        return null;
    }

    @Override
    public DocumentsLog getById(Long aLong) {
        return null;
    }

    @Override
    public DocumentsLog getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends DocumentsLog> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DocumentsLog> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DocumentsLog> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DocumentsLog> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DocumentsLog> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DocumentsLog> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends DocumentsLog, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends DocumentsLog> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsLog> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DocumentsLog> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<DocumentsLog> findAll() {
        return null;
    }

    @Override
    public List<DocumentsLog> findAllById(Iterable<Long> longs) {
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
    public void delete(DocumentsLog entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends DocumentsLog> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<DocumentsLog> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DocumentsLog> findAll(Pageable pageable) {
        return null;
    }
}
