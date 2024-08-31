package com.shibing.util.validation;


import com.shibing.model.HasId;
import com.shibing.error.IllegalRequestDataException;
import com.shibing.error.NotFoundException;
import lombok.experimental.UtilityClass;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.lang.NonNull;

import java.util.function.Supplier;


@UtilityClass
public class ValidationUtil {

    public static void checkNew(HasId bean) {
        if (!bean.isNew()) {
            throw new IllegalArgumentException(bean + " must be new (id=null)");
        }
    }

    public static void assureIdConsistent(HasId bean, int id) {
//      conservative when you reply, but accept liberally (http://stackoverflow.com/a/32728226/548473)
        if (bean.isNew()) {
            bean.setId(id);
        } else if (bean.id() != id) {
            throw new IllegalRequestDataException(bean + " must be with id=" + id);
        }
    }


    @NonNull
    public static Throwable getRootCause(@NonNull Throwable t) {
        Throwable rootCause = NestedExceptionUtils.getRootCause(t);
        return rootCause != null ? rootCause : t;
    }

    public static void checkModification(int count, int id) {
        if (count == 0) {
            throw new IllegalRequestDataException("Entity with id=" + id + " not found");
        }
    }

    public static Supplier<NotFoundException>notFound(String message) {
        return () -> new NotFoundException(message);
    }
}