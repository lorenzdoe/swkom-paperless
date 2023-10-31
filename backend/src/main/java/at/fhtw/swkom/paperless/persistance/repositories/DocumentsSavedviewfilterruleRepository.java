package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedviewfilterrule;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DocumentsSavedviewfilterruleRepository implements JpaRepository<DocumentsSavedviewfilterrule, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends DocumentsSavedviewfilterrule> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedviewfilterrule> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DocumentsSavedviewfilterrule> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DocumentsSavedviewfilterrule getOne(Long aLong) {
        return null;
    }

    @Override
    public DocumentsSavedviewfilterrule getById(Long aLong) {
        return null;
    }

    @Override
    public DocumentsSavedviewfilterrule getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedviewfilterrule> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DocumentsSavedviewfilterrule> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedviewfilterrule> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedviewfilterrule> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedviewfilterrule> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DocumentsSavedviewfilterrule> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends DocumentsSavedviewfilterrule, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedviewfilterrule> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsSavedviewfilterrule> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DocumentsSavedviewfilterrule> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<DocumentsSavedviewfilterrule> findAll() {
        return null;
    }

    @Override
    public List<DocumentsSavedviewfilterrule> findAllById(Iterable<Long> longs) {
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
    public void delete(DocumentsSavedviewfilterrule entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends DocumentsSavedviewfilterrule> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<DocumentsSavedviewfilterrule> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DocumentsSavedviewfilterrule> findAll(Pageable pageable) {
        return null;
    }
}
