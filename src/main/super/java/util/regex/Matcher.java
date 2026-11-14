/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

 package java.util.regex;

 import com.google.gwt.regexp.shared.RegExp;
 import com.google.gwt.regexp.shared.MatchResult;
 
 import akasha.Console;
 
 /**
  * Emulation of the {@link Matcher} class, uses {@link RegExp} as internal
  * implementation.
  * 
  * @author hneuer
  */
 public class Matcher {
     private final Pattern pattern;
     private final RegExp regExp;
     private final String input;
     private MatchResult matchResult;
 
     Matcher(Pattern pattern, CharSequence cs) {
         this.pattern = pattern;
         input = cs.toString();
         regExp = pattern.regExp;
     }
 
     public boolean find() {
         matchResult = regExp.exec(input);
         return matchResult != null;
     }
 
     public String group() {
         return group(0);
     }
 
     public boolean matches () {
         return find();
     }
 
     public int groupCount () {
         return matchResult.getGroupCount()-1;
     }
 
     public String replaceAll (String replacement) {
         return regExp.replace(input, replacement);
     }
 
     public String group (int group) {
         return matchResult.getGroup(group);
     }
 
     public int start() {
         return matchResult.getIndex();
     }
 
     public int end() {
         return regExp.getLastIndex();
     }
 }