package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedview;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DocumentsSavedviewRepository implements JpaRepository<DocumentsSavedview, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends DocumentsSavedview> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedview> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DocumentsSavedview> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DocumentsSavedview getOne(Long aLong) {
        return null;
    }

    @Override
    public DocumentsSavedview getById(Long aLong) {
        return null;
    }

    @Override
    public DocumentsSavedview getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedview> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DocumentsSavedview> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedview> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedview> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedview> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DocumentsSavedview> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends DocumentsSavedview, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedview> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedview> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DocumentsSavedview> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<DocumentsSavedview> findAll() {
        return null;
    }

    @Override
    public List<DocumentsSavedview> findAllById(Iterable<Long> longs) {
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
    public void delete(DocumentsSavedview entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends DocumentsSavedview> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<DocumentsSavedview> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DocumentsSavedview> findAll(Pageable pageable) {
        return null;
    }
}
