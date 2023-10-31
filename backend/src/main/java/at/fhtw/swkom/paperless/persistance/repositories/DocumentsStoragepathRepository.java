package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsStoragepath;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DocumentsStoragepathRepository implements JpaRepository<DocumentsStoragepath, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends DocumentsStoragepath> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsStoragepath> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DocumentsStoragepath> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DocumentsStoragepath getOne(Long aLong) {
        return null;
    }

    @Override
    public DocumentsStoragepath getById(Long aLong) {
        return null;
    }

    @Override
    public DocumentsStoragepath getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends DocumentsStoragepath> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DocumentsStoragepath> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DocumentsStoragepath> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DocumentsStoragepath> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DocumentsStoragepath> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DocumentsStoragepath> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends DocumentsStoragepath, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends DocumentsStoragepath> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsStoragepath> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DocumentsStoragepath> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<DocumentsStoragepath> findAll() {
        return null;
    }

    @Override
    public List<DocumentsStoragepath> findAllById(Iterable<Long> longs) {
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
    public void delete(DocumentsStoragepath entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends DocumentsStoragepath> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<DocumentsStoragepath> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DocumentsStoragepath> findAll(Pageable pageable) {
        return null;
    }
}
