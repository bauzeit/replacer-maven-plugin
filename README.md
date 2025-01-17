# replacer-maven-plugin

based on <https://github.com/bakersemail/maven-replacer-plugin>


## Introduction

  Maven plugin to replace tokens in a given file with a value.
  
  (from `mvn replacer:help -Ddetail=true`)

### Goals

  - replacer:replace - Goal replaces token with value inside file

### Available parameters

  - basedir (Default: ${basedir})  
    Optional base directory for each file to replace. Path to base relative
    files for replacements from. This feature is useful for multi-module
    projects. Default '.' which is the default Maven basedir.

  - commentsEnabled (Default: true)  
    Comments enabled in the tokenValueMapFile. Comment lines start with '#'.
    If your token starts with an '#' then you must supply the commentsEnabled
    parameter and with a value of false. Default is true.

  - delimiters  
    Add a list of delimiters which are added on either side of tokens to match
    against. You may also use the '' character to place the token in the
    desired location for matching. e.g. @ would match @token@. e.g. ${} would
    match ${token}.

  - encoding (Default: ${project.build.sourceEncoding})  
    File encoding used when reading and writing files. Default system encoding
    used when not specified.

  - excludes  
    List of files to exclude for multiple (or single) replacement. In Ant
    format (`*/directory/**.properties`) Cannot use with outputFile.

  - file  
    File to check and replace tokens. Path to single file to replace tokens
    in. The file must be text (ascii). Based on current execution path.

  - filesToExclude  
    List of comma separated files to exclude (must have some includes) for
    multiple (or single) replacement. This is split up and used the same way a
    array of excludes would be. In Ant format
    (`**/directory/do-not-replace.properties`). The files replaced will be
    derived from the list of includes and excludes.

  - filesToInclude  
    Comma separated list of includes. This is split up and used the same way a
    array of includes would be. In Ant format (`*/directory/**.properties`).
    Files not found are ignored by default.

  - ignoreErrors (Default: false)  
    Ignore any errors produced by this plugin such as files not being found
    and continue with the build. First checks if file exists and exits without
    attempting to replace anything. Only usable with file parameter.

  - ignoreMissingFile  
    Ignore missing target file. Use only with file configuration (not includes
    etc). Set to true to not fail build if the file is not found. First checks
    if file exists and exits without attempting to replace anything.

  - includes  
    List of files to include for multiple (or single) replacement. In Ant
    format (`*/directory/**.properties`) Cannot use with outputFile.

  - inputFilePattern  
    Regular expression is run on an input file's name to create the output
    file with. Must be used in conjunction with outputFilePattern.

  - maxReplacements  
    Set a maximum number of files which can be replaced per execution.

  - outputBasedir  
    Base directory (appended) to use for outputDir. Having this existing but
    blank will cause the outputDir to be based on the execution directory.

  - outputDir  
    Output to another dir. Destination directory relative to the execution
    directory for all replaced files to be written to. Use with outputDir to
    have files written to a specific base location.

  - outputFile  
    Output to another file. The input file is read and the final output (after
    replacing tokens) is written to this file. The path and file are created
    if it does not exist. If it does exist, the contents are overwritten. You
    should not use outputFile when using a list of includes.

  - outputFilePattern  
    Regular expression groups from inputFilePattern are used in this pattern
    to create an output file per input file. Must be used in conjunction with
    inputFilePattern. The parameter outputFile is ignored when
    outputFilePattern is used.

  - preserveDir (Default: true)  
    Parent directory is preserved when replacing files found from includes and
    being written to an outputDir. Default is true.

  - quiet (Default: false)  
    Stops printing a summary of files that have had replacements performed
    upon them when true. Default is false.

  - regex  
    Indicates if the token should be located with regular expressions. This
    should be set to false if the token contains regex characters which may
    miss the desired tokens or even replace the wrong tokens.

  - regexFlags  
    List of standard Java regular expression Pattern flags (see Java Doc).
    Must contain one or more of:
     - CANON_EQ
     - CASE_INSENSITIVE
     - COMMENTS
     - DOTALL
     - LITERAL
     - MULTILINE
     - UNICODE_CASE
     - UNIX_LINES

  - replacements  
    List of replacements with token/value pairs. Each replacement element to
    contain sub-elements as token/value pairs. Each token within the given
    file will be replaced by it's respective value.

  - skip (Default: false)  
    Skip running this plugin. Default is false.

  - token  
    Token to replace. The text to replace within the given file. This may or
    may not be a regular expression (see regex notes above).

  - tokenFile  
    Token file containing a token to be replaced in the target file/s. May be
    multiple words or lines. This is useful if you do not wish to expose the
    token within your pom or the token is long.

  - tokenValueMap  
    Map of tokens and respective values to replace with. A file containing
    tokens and respective values to replace with. This file may contain
    multiple entries to support a single file containing different tokens to
    have replaced. Each token/value pair should be in the format:
    'token=value' (without quotations). If your token contains ='s you must
    escape the = character to `\=`. e.g. `tok\=en=value`

  - unescape (Default: false)  
    Unescape tokens and values to Java format. e.g. `token\n` is unescaped to
    `token(carriage return)`. Default is false.

  - value  
    Value to replace token with. The text to be written over any found tokens.
    If no value is given, the tokens found are replaced with an empty string
    (effectively removing any tokens found). You can also reference grouped
    regex matches made in the token here by $1, $2, etc.

  - valueFile  
    A file containing a value to replace the given token with. May be multiple
    words or lines. This is useful if you do not wish to expose the value
    within your pom or the value is long.

  - variableTokenValueMap  
    Variable tokenValueMap. Same as the tokenValueMap but can be an include
    configuration rather than an outside property file. Similar to
    tokenValueMap but incline configuration inside the pom. This parameter may
    contain multiple entries to support a single file containing different
    tokens to have replaced. Format is comma separated. e.g.
    token=value,token2=value2 Comments are not supported.

  - xpath  
    X-Path expression for locating node's whose content you wish to replace.
    This is useful if you have the same token appearing in many nodes but wish
    to only replace the contents of one or more of them.
