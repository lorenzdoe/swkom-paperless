package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AuthGroupRepository implements JpaRepository<AuthGroup, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends AuthGroup> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends AuthGroup> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<AuthGroup> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AuthGroup getOne(Long aLong) {
        return null;
    }

    @Override
    public AuthGroup getById(Long aLong) {
        return null;
    }

    @Override
    public AuthGroup getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends AuthGroup> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AuthGroup> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends AuthGroup> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends AuthGroup> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AuthGroup> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AuthGroup> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AuthGroup, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends AuthGroup> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AuthGroup> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AuthGroup> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<AuthGroup> findAll() {
        return null;
    }

    @Override
    public List<AuthGroup> findAllById(Iterable<Long> longs) {
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
    public void delete(AuthGroup entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AuthGroup> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AuthGroup> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AuthGroup> findAll(Pageable pageable) {
        return null;
    }
}
