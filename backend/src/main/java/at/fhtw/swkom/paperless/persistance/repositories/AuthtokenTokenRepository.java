package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthGroup;
import at.fhtw.swkom.paperless.persistance.entities.AuthtokenToken;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AuthtokenTokenRepository implements JpaRepository<AuthtokenToken, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends AuthtokenToken> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends AuthtokenToken> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<AuthtokenToken> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public AuthtokenToken getOne(Long aLong) {
        return null;
    }

    @Override
    public AuthtokenToken getById(Long aLong) {
        return null;
    }

    @Override
    public AuthtokenToken getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends AuthtokenToken> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends AuthtokenToken> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends AuthtokenToken> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends AuthtokenToken> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends AuthtokenToken> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends AuthtokenToken> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends AuthtokenToken, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends AuthtokenToken> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AuthtokenToken> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AuthtokenToken> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<AuthtokenToken> findAll() {
        return null;
    }

    @Override
    public List<AuthtokenToken> findAllById(Iterable<Long> longs) {
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
    public void delete(AuthtokenToken entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AuthtokenToken> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<AuthtokenToken> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<AuthtokenToken> findAll(Pageable pageable) {
        return null;
    }
}
