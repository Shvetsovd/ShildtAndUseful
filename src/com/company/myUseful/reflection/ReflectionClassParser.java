package company.myUseful.reflection;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

// TODO: 07.04.2017 Add reflection for inner classes and interfaces
public class ReflectionClassParser {
    public static String[] parse(@NotNull Class<?> className) {
        List<String> classInfo = new ArrayList<>();

        getTitleClassInfo(className, classInfo);

        classInfo.set(0, classInfo.get(0) + " {");

        classInfo.add("\t//Fields:");
        getFieldsInfo("\t", className, classInfo);

        classInfo.add("\n\t//Constructors:");
        getConstructorsInfo("\t", className, classInfo);

        classInfo.add("\n\t//Methods:");
        getMethodsInfo("\t", className, classInfo);

        classInfo.add("}");

        //toar
        return classInfo.toArray(new String[classInfo.size()]);
    }

    private static void getTitleClassInfo(@NotNull Class<?> target, List<String> classInfo) {
        classInfo.add(getModifiersInfo(target.getModifiers()));

        if (target.isInterface()) {
            classInfo.set(0, classInfo.get(0) + "interface ");
        } else {
            classInfo.set(0, classInfo.get(0) + "interface ");
        }
        classInfo.set(0, classInfo.get(0) + target.getSimpleName());

        Class<?> superclass = target.getSuperclass();
        if ((superclass) != null) {
            classInfo.set(0, classInfo.get(0) + " extends " + superclass.getSimpleName());
        }
    }

    private static void getFieldsInfo(String startStr, Class<?> target, List<String> classInfo) {
        Field[] fields = target.getFields();

        for (Field field : fields) {
            StringBuilder finfo = new StringBuilder(startStr);
            int mods = field.getModifiers();

            finfo.append(getModifiersInfo(mods));
            finfo.append(getShortClassName(field.getName()));
            finfo.append(";");

            classInfo.add(finfo.toString());
        }
    }

    private static void getConstructorsInfo(String startStr, Class<?> target, List<String> classInfo) {
        Constructor[] cons = target.getConstructors();
        for (Constructor con : cons) {
            StringBuilder minfo = new StringBuilder(startStr);
            int mods = con.getModifiers();

            minfo.append(getModifiersInfo(mods));
            minfo.append("   ");
            minfo.append(getShortClassName(con.getName()));
            minfo.append("(");
            minfo.append(getConstructorsParametersInfo(con));
            minfo.append("){ }");

            classInfo.add(minfo.toString());
        }
    }

    private static void getMethodsInfo(String startStr, Class<?> target, List<String> classInfo) {
        Method[] methods = target.getMethods();
        for (Method method : methods) {
            StringBuilder minfo = new StringBuilder(startStr);
            int mods = method.getModifiers();

            minfo.append(getModifiersInfo(mods));
            minfo.append(method.getReturnType().getSimpleName());
            minfo.append("   ");
            minfo.append(getShortClassName(method.getName()));
            minfo.append("(");
            minfo.append(getMethodsParametersInfo(method));
            minfo.append("){ }");

            classInfo.add(minfo.toString());
        }
    }

    private static String getShortClassName(String name) {

        if (name.lastIndexOf('.') == -1) {
            return name;
        }

        StringBuilder clName = new StringBuilder(name.trim());


        clName.delete(0, clName.lastIndexOf(".") + 1);
        if (clName.charAt(clName.length() - 1) == ';') {
            clName.deleteCharAt(clName.length() - 1);
            clName.append("[]");
        }
        return clName.toString();
    }

    private static String getModifiersInfo(int mods) {
        StringBuilder info = new StringBuilder();
        if (Modifier.isPublic(mods)) {
            info.append("public ");
        }
        if (Modifier.isPrivate(mods)) {
            info.append("private ");
        }
        if (Modifier.isProtected(mods)) {
            info.append("protected ");
        }
        if (Modifier.isStatic(mods)) {
            info.append("static ");
        }
        if (Modifier.isFinal(mods)) {
            info.append("final ");
        }
        if (Modifier.isAbstract(mods)) {
            info.append("abstract ");
        }

        return info.toString();
    }

    private static String getMethodsParametersInfo(Method method) {
        Class<?>[] params = method.getParameterTypes();
        return getParametersInfo(params);
    }

    private static String getConstructorsParametersInfo(Constructor con) {
        Class<?>[] params = con.getParameterTypes();
        return getParametersInfo(params);

    }

    private static String getParametersInfo(Class<?>[] params) {
        StringBuilder paraminfo = new StringBuilder();

        for (Class<?> param : params) {
            paraminfo.append(" " + param.getSimpleName());
            param.getClasses();
            paraminfo.append(",");
        }
        if (paraminfo.lastIndexOf(",") != -1) {
            paraminfo.deleteCharAt(paraminfo.lastIndexOf(","));
        }
        return paraminfo.toString().trim();
    }

}
