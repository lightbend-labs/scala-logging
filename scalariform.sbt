import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import scalariform.formatter.preferences.{AlignSingleLineCaseStatements, DoubleIndentConstructorArguments}

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentConstructorArguments, true)
