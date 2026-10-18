Before java 14

the exception shown in the console was as follows.
The line number identifies where the exception occurred,
but it may not tell you which reference in the chained expression was null.

Exception in thread "main" java.lang.NullPointerException
    at HelpfulNpeExercise.main(HelpfulNpeExercise.java:...)


After java 14

Exception in thread "main" java.lang.NullPointerException:
Cannot invoke "com.learn.java_version_lab.java16.exercise_12_NPE.City.getName()"
because the return value of "com.learn.java_version_lab.java16.exercise_12_NPE.Address.getCity()" is null
	at com.learn.java_version_lab.java16.exercise_12_NPE.Test.main(Test.java:31)