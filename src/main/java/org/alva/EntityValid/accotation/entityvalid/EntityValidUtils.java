package org.alva.EntityValid.accotation.entityvalid;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class EntityValidUtils {

    public static ValidResult validate(Object object) {
        ValidResult result = new ValidResult();
        result.setSucceed(true);
        result.setMessage("验证通过");

        Class<?> clz = object.getClass();

        //检测field是否存在
        try {
            //获取实体类的字段集合
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                //通过反射获取该属性对应的值 Java的访问限制
                field.setAccessible(true);
                Object value = field.get(object);
                //获取字段上的注解集合
                Annotation[] annotations = field.getAnnotations();
                for (Annotation annotation : annotations) {
                    //获取注解类型 (注解类的Class)
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    //获取注解类中的方法集合
                    Method[] declaredMethods = annotationType.getDeclaredMethods();
                    for (Method method : declaredMethods) {
                        String methodName = method.getName();
                        if ("description".equals(methodName)) {
                            continue;
                        }

                        //初始化注解验证的方法处理类
                        Object obj = EntityValidUtils.class.newInstance();
                        //获取方法
                        try {
                            //根据方法名获取该方法
                            Method m = obj.getClass().getDeclaredMethod(methodName, Object.class, Field.class);
                            //调用该方法
                            result = (ValidResult) m.invoke(obj, value, field);

                            //验证结果 有一处失败则退出
                            if (result.isSucceed() == false) {
                                return result;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private ValidResult isEmpty(Object value, Field field) {
        ValidResult result = new ValidResult();
        Valid annotation = field.getAnnotation(Valid.class);
        if (!annotation.isEmpty()) {
            if (value == null || "".equals(value)) {
                result.setMessage(annotation.description() + "为必填项!");
                result.setSucceed(false);
            } else {
                result.setMessage("验证通过");
                result.setSucceed(true);
            }
        } else {
            result.setMessage("验证通过");
            result.setSucceed(true);
        }

        return result;
    }

    private ValidResult maxLength(Object value, Field field) {
        ValidResult result = new ValidResult();
        Valid annotation = field.getAnnotation(Valid.class);
        if (null != value) {
            if (value.toString().length() < annotation.maxLength()) {
                result.setMessage("验证成功");
                result.setSucceed(true);
            } else {
                result.setMessage(annotation.description() + "最大长度不能超过" + annotation.maxLength());
                result.setSucceed(false);
            }
        } else {
            result.setMessage("验证成功");
            result.setSucceed(true);
        }
        return result;
    }

    private ValidResult minLength(Object value, Field field) {
        ValidResult result = new ValidResult();
        Valid annotation = field.getAnnotation(Valid.class);
        if (annotation.minLength() != 0 && null != value) {
            if (value.toString().length() > annotation.minLength()) {
                result.setMessage("验证成功");
                result.setSucceed(true);
            } else {
                result.setMessage(annotation.description() + "最小长度不能小于" + annotation.minLength());
                result.setSucceed(false);
            }
        } else if (annotation.minLength() == 0) {
            result.setMessage("验证成功");
            result.setSucceed(true);
        } else {
            result.setMessage(annotation.description() + "最小长度不能小于" + annotation.minLength());
            result.setSucceed(false);
        }
        return result;
    }

    private ValidResult regex(Object value, Field field) {
        ValidResult result = new ValidResult();
        Valid annotation = field.getAnnotation(Valid.class);

        String pattern = annotation.regex();
        if ((null == pattern) || ("".equals(pattern))) {
            result.setMessage("验证成功");
            result.setSucceed(true);
        } else {
            boolean isMatch = Pattern.matches(pattern, value.toString());
            if (isMatch) {
                result.setMessage("验证成功");
                result.setSucceed(true);
            } else {
                result.setMessage(annotation.description() + "格式错误");
                result.setSucceed(false);
            }
        }
        return result;
    }
}
