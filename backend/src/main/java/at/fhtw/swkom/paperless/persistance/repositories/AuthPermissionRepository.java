package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.entities.AuthPermission;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AuthPermissionRepository implements JpaRepository<AuthPermission, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends AuthPermission> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends AuthPermission> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<AuthPermission> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AuthPermission getOne(Long aLong) {
        return null;
    }

    @Override
    public AuthPermission getById(Long aLong) {
        return null;
    }

    @Override
    public AuthPermission getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends AuthPermission> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AuthPermission> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends AuthPermission> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends AuthPermission> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AuthPermission> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AuthPermission> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AuthPermission, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends AuthPermission> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AuthPermission> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AuthPermission> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<AuthPermission> findAll() {
        return null;
    }

    @Override
    public List<AuthPermission> findAllById(Iterable<Long> longs) {
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
    public void delete(AuthPermission entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AuthPermission> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AuthPermission> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AuthPermission> findAll(Pageable pageable) {
        return null;
    }
}
