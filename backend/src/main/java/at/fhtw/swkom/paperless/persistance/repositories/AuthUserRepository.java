package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.entities.AuthUser;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AuthUserRepository implements JpaRepository<AuthUser, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends AuthUser> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends AuthUser> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<AuthUser> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AuthUser getOne(Long aLong) {
        return null;
    }

    @Override
    public AuthUser getById(Long aLong) {
        return null;
    }

    @Override
    public AuthUser getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends AuthUser> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AuthUser> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends AuthUser> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends AuthUser> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AuthUser> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AuthUser> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AuthUser, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends AuthUser> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AuthUser> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AuthUser> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<AuthUser> findAll() {
        return null;
    }

    @Override
    public List<AuthUser> findAllById(Iterable<Long> longs) {
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
    public void delete(AuthUser entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AuthUser> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AuthUser> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AuthUser> findAll(Pageable pageable) {
        return null;
    }
}
