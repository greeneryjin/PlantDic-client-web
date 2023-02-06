package com.example.demo.plantDic.repository;

import com.example.demo.plantDic.dto.request.FilterDto;
import com.example.demo.plantDic.model.MyGardenDtl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;
import static com.example.demo.plantDic.model.QMyGardenDtl.myGardenDtl;
import static com.example.demo.plantDic.model.QMyGardenDtlPicture.myGardenDtlPicture;
import static com.example.demo.plantDic.model.QPest.pest;

public class MyGardenDtlRepositoryImpl implements MyGardenDtlRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MyGardenDtlRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<MyGardenDtl> searchFilter(Pageable pageable, FilterDto filter) {
        QueryResults<MyGardenDtl> queryResults = queryFactory
                .selectFrom(myGardenDtl)
                .where(filterSum(filter.getClCode(), filter.getLighttdemanddoCode(), filter.getHdCode(), filter.getGrwhTpCode()
                        ,filter.getLefcolrCode(), filter.getLefmrkCode(), filter.getManagelevelCode(), filter.getPostngplaceCode()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        List<MyGardenDtl> content = queryResults.getResults();
        long total = queryResults.getTotal();
        return new PageImpl<>(content, pageable, total);
    }

    private BooleanBuilder clCode(String clCode) {
        if(clCode == null) {
            return new BooleanBuilder();
        }else {
            return new BooleanBuilder(myGardenDtl.clCode.contains(clCode));
        }
    }

    private BooleanBuilder lightcode(String lighttdemanddoCode) {
        if(lighttdemanddoCode == null){
            return new BooleanBuilder();
        }else {
            return new BooleanBuilder(myGardenDtl.lighttdemanddoCode.contains(lighttdemanddoCode));
        }
    }

    private BooleanBuilder hdCode(String hdCode) {
        if(hdCode == null){
            return new BooleanBuilder();
        }else {
            return new BooleanBuilder(myGardenDtl.hdCode.contains(hdCode));
        }
    }

    private BooleanBuilder grwhTpCode(String grwhTpCode) {
        if(grwhTpCode == null){
            return new BooleanBuilder();
        }else {
            return new BooleanBuilder(myGardenDtl.grwhTpCode.contains(grwhTpCode));
        }
    }

    private BooleanBuilder lefcolr(String lefcolrCode) {
        if(lefcolrCode == null){
            return new BooleanBuilder();
        }else {
            return new BooleanBuilder(myGardenDtl.lefcolrCode.contains(lefcolrCode));
        }
    }

    private BooleanBuilder lefmrk(String lefmrkCode) {
        if(lefmrkCode == null){
            return new BooleanBuilder();
        }else {
            return new BooleanBuilder(myGardenDtl.lefmrkCode.contains(lefmrkCode));
        }
    }

    private BooleanBuilder managed(String managelevelCode) {
        if(managelevelCode == null){
            return new BooleanBuilder();
        }else {
            return new BooleanBuilder(myGardenDtl.managelevelCode.contains(managelevelCode));
        }
    }

    private BooleanBuilder postng(String postngplaceCode) {
        if(postngplaceCode == null){
            return new BooleanBuilder();
        }else {
            return new BooleanBuilder(myGardenDtl.postngplaceCode.contains(postngplaceCode));
        }
    }

    private BooleanBuilder filterSum(String clCode, String lighttdemanddoCode, String hdCode, String grwhstleCode,
                                     String lefcolrCode, String lefmrkCode, String managelevelCode, String postngplaceCode){

        return clCode(clCode).and(lightcode(lighttdemanddoCode)).and(hdCode(hdCode)).and(grwhTpCode(grwhstleCode))
                .and(lefcolr(lefcolrCode)).and(lefmrk(lefmrkCode)).and(managed(managelevelCode)).and(postng(postngplaceCode));
    }
}