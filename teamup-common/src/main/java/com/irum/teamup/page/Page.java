package com.irum.teamup.page;

import com.irum.teamup.utils.BeanUtils;
import com.irum.teamup.utils.CollUtils;
import com.irum.teamup.utils.Convert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    protected Long total;
    protected Long pages;
    protected List<T> list;

    public static <T> Page<T> empty(Long total, Long pages) {
        return new Page<>(total, pages, CollUtils.emptyList());
    }
    public static <T> Page<T> empty(com.baomidou.mybatisplus.extension.plugins.pagination.Page<?> page) {
        return new Page<>(page.getTotal(), page.getPages(), CollUtils.emptyList());
    }

    public static <T> Page<T> of(com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> page) {
        if(page == null){
            return new Page<>();
        }
        if (CollUtils.isEmpty(page.getRecords())) {
            return empty(page);
        }
        return new Page<>(page.getTotal(), page.getPages(), page.getRecords());
    }
    public static <T,R> Page<T> of(com.baomidou.mybatisplus.extension.plugins.pagination.Page<R> page, Function<R, T> mapper) {
        if(page == null){
            return new Page<>();
        }
        if (CollUtils.isEmpty(page.getRecords())) {
            return empty(page);
        }
        return new Page<>(page.getTotal(), page.getPages(),
                page.getRecords().stream().map(mapper).collect(Collectors.toList()));
    }
    public static <T> Page<T> of(com.baomidou.mybatisplus.extension.plugins.pagination.Page<?> page, List<T> list) {
        return new Page<>(page.getTotal(), page.getPages(), list);
    }

    public static <T, R> Page<T> of(com.baomidou.mybatisplus.extension.plugins.pagination.Page<R> page, Class<T> clazz) {
        return new Page<>(page.getTotal(), page.getPages(), BeanUtils.copyList(page.getRecords(), clazz));
    }

    public static <T, R> Page<T> of(com.baomidou.mybatisplus.extension.plugins.pagination.Page<R> page, Class<T> clazz, Convert<R, T> convert) {
        return new Page<>(page.getTotal(), page.getPages(), BeanUtils.copyList(page.getRecords(), clazz, convert));
    }
}
