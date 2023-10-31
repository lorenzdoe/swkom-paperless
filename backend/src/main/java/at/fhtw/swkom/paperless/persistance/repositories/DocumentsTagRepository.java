package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsTag;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DocumentsTagRepository implements JpaRepository<DocumentsTag, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends DocumentsTag> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsTag> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DocumentsTag> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DocumentsTag getOne(Long aLong) {
        return null;
    }

    @Override
    public DocumentsTag getById(Long aLong) {
        return null;
    }

    @Override
    public DocumentsTag getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends DocumentsTag> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DocumentsTag> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DocumentsTag> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DocumentsTag> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DocumentsTag> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DocumentsTag> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends DocumentsTag, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends DocumentsTag> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsTag> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DocumentsTag> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<DocumentsTag> findAll() {
        return null;
    }

    @Override
    public List<DocumentsTag> findAllById(Iterable<Long> longs) {
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
    public void delete(DocumentsTag entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends DocumentsTag> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<DocumentsTag> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DocumentsTag> findAll(Pageable pageable) {
        return null;
    }
}
