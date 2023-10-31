package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import at.fhtw.swkom.paperless.persistance.entities.AuthUserUserPermission;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AuthUserUserPermissionRepository implements JpaRepository<AuthUserUserPermission, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends AuthUserUserPermission> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends AuthUserUserPermission> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<AuthUserUserPermission> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AuthUserUserPermission getOne(Long aLong) {
        return null;
    }

    @Override
    public AuthUserUserPermission getById(Long aLong) {
        return null;
    }

    @Override
    public AuthUserUserPermission getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends AuthUserUserPermission> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AuthUserUserPermission> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends AuthUserUserPermission> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends AuthUserUserPermission> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AuthUserUserPermission> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AuthUserUserPermission> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AuthUserUserPermission, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends AuthUserUserPermission> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AuthUserUserPermission> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AuthUserUserPermission> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<AuthUserUserPermission> findAll() {
        return null;
    }

    @Override
    public List<AuthUserUserPermission> findAllById(Iterable<Long> longs) {
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
    public void delete(AuthUserUserPermission entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AuthUserUserPermission> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AuthUserUserPermission> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AuthUserUserPermission> findAll(Pageable pageable) {
        return null;
    }
}
