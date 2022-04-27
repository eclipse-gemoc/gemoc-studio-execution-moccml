package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.services.TestScenarioLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTestScenarioLangParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Scenario'", "'importModel'", "'as'", "';'", "'importClass'", "'importPackage'", "'Variable'", "':'", "'.'", "'*'", "'expect'", "'and'", "'execute'", "'('", "')'", "','"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalTestScenarioLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTestScenarioLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTestScenarioLangParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTestScenarioLang.g"; }


     
     	private TestScenarioLangGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TestScenarioLangGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleScenario"
    // InternalTestScenarioLang.g:60:1: entryRuleScenario : ruleScenario EOF ;
    public final void entryRuleScenario() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:61:1: ( ruleScenario EOF )
            // InternalTestScenarioLang.g:62:1: ruleScenario EOF
            {
             before(grammarAccess.getScenarioRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleScenario();

            state._fsp--;

             after(grammarAccess.getScenarioRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleScenario"


    // $ANTLR start "ruleScenario"
    // InternalTestScenarioLang.g:69:1: ruleScenario : ( ( rule__Scenario__Group__0 ) ) ;
    public final void ruleScenario() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:73:2: ( ( ( rule__Scenario__Group__0 ) ) )
            // InternalTestScenarioLang.g:74:1: ( ( rule__Scenario__Group__0 ) )
            {
            // InternalTestScenarioLang.g:74:1: ( ( rule__Scenario__Group__0 ) )
            // InternalTestScenarioLang.g:75:1: ( rule__Scenario__Group__0 )
            {
             before(grammarAccess.getScenarioAccess().getGroup()); 
            // InternalTestScenarioLang.g:76:1: ( rule__Scenario__Group__0 )
            // InternalTestScenarioLang.g:76:2: rule__Scenario__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenarioAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleImportStatement"
    // InternalTestScenarioLang.g:88:1: entryRuleImportStatement : ruleImportStatement EOF ;
    public final void entryRuleImportStatement() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:89:1: ( ruleImportStatement EOF )
            // InternalTestScenarioLang.g:90:1: ruleImportStatement EOF
            {
             before(grammarAccess.getImportStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleImportStatement();

            state._fsp--;

             after(grammarAccess.getImportStatementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImportStatement"


    // $ANTLR start "ruleImportStatement"
    // InternalTestScenarioLang.g:97:1: ruleImportStatement : ( ( rule__ImportStatement__Group__0 ) ) ;
    public final void ruleImportStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:101:2: ( ( ( rule__ImportStatement__Group__0 ) ) )
            // InternalTestScenarioLang.g:102:1: ( ( rule__ImportStatement__Group__0 ) )
            {
            // InternalTestScenarioLang.g:102:1: ( ( rule__ImportStatement__Group__0 ) )
            // InternalTestScenarioLang.g:103:1: ( rule__ImportStatement__Group__0 )
            {
             before(grammarAccess.getImportStatementAccess().getGroup()); 
            // InternalTestScenarioLang.g:104:1: ( rule__ImportStatement__Group__0 )
            // InternalTestScenarioLang.g:104:2: rule__ImportStatement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportStatement"


    // $ANTLR start "entryRuleImportJavaStatement"
    // InternalTestScenarioLang.g:116:1: entryRuleImportJavaStatement : ruleImportJavaStatement EOF ;
    public final void entryRuleImportJavaStatement() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:117:1: ( ruleImportJavaStatement EOF )
            // InternalTestScenarioLang.g:118:1: ruleImportJavaStatement EOF
            {
             before(grammarAccess.getImportJavaStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleImportJavaStatement();

            state._fsp--;

             after(grammarAccess.getImportJavaStatementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImportJavaStatement"


    // $ANTLR start "ruleImportJavaStatement"
    // InternalTestScenarioLang.g:125:1: ruleImportJavaStatement : ( ( rule__ImportJavaStatement__Group__0 ) ) ;
    public final void ruleImportJavaStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:129:2: ( ( ( rule__ImportJavaStatement__Group__0 ) ) )
            // InternalTestScenarioLang.g:130:1: ( ( rule__ImportJavaStatement__Group__0 ) )
            {
            // InternalTestScenarioLang.g:130:1: ( ( rule__ImportJavaStatement__Group__0 ) )
            // InternalTestScenarioLang.g:131:1: ( rule__ImportJavaStatement__Group__0 )
            {
             before(grammarAccess.getImportJavaStatementAccess().getGroup()); 
            // InternalTestScenarioLang.g:132:1: ( rule__ImportJavaStatement__Group__0 )
            // InternalTestScenarioLang.g:132:2: rule__ImportJavaStatement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportJavaStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportJavaStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportJavaStatement"


    // $ANTLR start "entryRuleObjectVariable"
    // InternalTestScenarioLang.g:144:1: entryRuleObjectVariable : ruleObjectVariable EOF ;
    public final void entryRuleObjectVariable() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:145:1: ( ruleObjectVariable EOF )
            // InternalTestScenarioLang.g:146:1: ruleObjectVariable EOF
            {
             before(grammarAccess.getObjectVariableRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleObjectVariable();

            state._fsp--;

             after(grammarAccess.getObjectVariableRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObjectVariable"


    // $ANTLR start "ruleObjectVariable"
    // InternalTestScenarioLang.g:153:1: ruleObjectVariable : ( ( rule__ObjectVariable__Group__0 ) ) ;
    public final void ruleObjectVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:157:2: ( ( ( rule__ObjectVariable__Group__0 ) ) )
            // InternalTestScenarioLang.g:158:1: ( ( rule__ObjectVariable__Group__0 ) )
            {
            // InternalTestScenarioLang.g:158:1: ( ( rule__ObjectVariable__Group__0 ) )
            // InternalTestScenarioLang.g:159:1: ( rule__ObjectVariable__Group__0 )
            {
             before(grammarAccess.getObjectVariableAccess().getGroup()); 
            // InternalTestScenarioLang.g:160:1: ( rule__ObjectVariable__Group__0 )
            // InternalTestScenarioLang.g:160:2: rule__ObjectVariable__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ObjectVariable__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObjectVariableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjectVariable"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // InternalTestScenarioLang.g:172:1: entryRuleQualifiedNameWithWildCard : ruleQualifiedNameWithWildCard EOF ;
    public final void entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:173:1: ( ruleQualifiedNameWithWildCard EOF )
            // InternalTestScenarioLang.g:174:1: ruleQualifiedNameWithWildCard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildCardRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQualifiedNameWithWildCard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildCardRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // InternalTestScenarioLang.g:181:1: ruleQualifiedNameWithWildCard : ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildCard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:185:2: ( ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) )
            // InternalTestScenarioLang.g:186:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            {
            // InternalTestScenarioLang.g:186:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            // InternalTestScenarioLang.g:187:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup()); 
            // InternalTestScenarioLang.g:188:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            // InternalTestScenarioLang.g:188:2: rule__QualifiedNameWithWildCard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedNameWithWildCard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalTestScenarioLang.g:200:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:201:1: ( ruleQualifiedName EOF )
            // InternalTestScenarioLang.g:202:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalTestScenarioLang.g:209:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:213:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalTestScenarioLang.g:214:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalTestScenarioLang.g:214:1: ( ( rule__QualifiedName__Group__0 ) )
            // InternalTestScenarioLang.g:215:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalTestScenarioLang.g:216:1: ( rule__QualifiedName__Group__0 )
            // InternalTestScenarioLang.g:216:2: rule__QualifiedName__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleJvmTypeReference"
    // InternalTestScenarioLang.g:228:1: entryRuleJvmTypeReference : ruleJvmTypeReference EOF ;
    public final void entryRuleJvmTypeReference() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:229:1: ( ruleJvmTypeReference EOF )
            // InternalTestScenarioLang.g:230:1: ruleJvmTypeReference EOF
            {
             before(grammarAccess.getJvmTypeReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleJvmTypeReference();

            state._fsp--;

             after(grammarAccess.getJvmTypeReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // InternalTestScenarioLang.g:237:1: ruleJvmTypeReference : ( ( rule__JvmTypeReference__Group__0 ) ) ;
    public final void ruleJvmTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:241:2: ( ( ( rule__JvmTypeReference__Group__0 ) ) )
            // InternalTestScenarioLang.g:242:1: ( ( rule__JvmTypeReference__Group__0 ) )
            {
            // InternalTestScenarioLang.g:242:1: ( ( rule__JvmTypeReference__Group__0 ) )
            // InternalTestScenarioLang.g:243:1: ( rule__JvmTypeReference__Group__0 )
            {
             before(grammarAccess.getJvmTypeReferenceAccess().getGroup()); 
            // InternalTestScenarioLang.g:244:1: ( rule__JvmTypeReference__Group__0 )
            // InternalTestScenarioLang.g:244:2: rule__JvmTypeReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__JvmTypeReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJvmTypeReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleStatement"
    // InternalTestScenarioLang.g:256:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:257:1: ( ruleStatement EOF )
            // InternalTestScenarioLang.g:258:1: ruleStatement EOF
            {
             before(grammarAccess.getStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getStatementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalTestScenarioLang.g:265:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:269:2: ( ( ( rule__Statement__Alternatives ) ) )
            // InternalTestScenarioLang.g:270:1: ( ( rule__Statement__Alternatives ) )
            {
            // InternalTestScenarioLang.g:270:1: ( ( rule__Statement__Alternatives ) )
            // InternalTestScenarioLang.g:271:1: ( rule__Statement__Alternatives )
            {
             before(grammarAccess.getStatementAccess().getAlternatives()); 
            // InternalTestScenarioLang.g:272:1: ( rule__Statement__Alternatives )
            // InternalTestScenarioLang.g:272:2: rule__Statement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Statement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStatementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleMseStatement"
    // InternalTestScenarioLang.g:284:1: entryRuleMseStatement : ruleMseStatement EOF ;
    public final void entryRuleMseStatement() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:285:1: ( ruleMseStatement EOF )
            // InternalTestScenarioLang.g:286:1: ruleMseStatement EOF
            {
             before(grammarAccess.getMseStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMseStatement();

            state._fsp--;

             after(grammarAccess.getMseStatementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMseStatement"


    // $ANTLR start "ruleMseStatement"
    // InternalTestScenarioLang.g:293:1: ruleMseStatement : ( ( rule__MseStatement__Group__0 ) ) ;
    public final void ruleMseStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:297:2: ( ( ( rule__MseStatement__Group__0 ) ) )
            // InternalTestScenarioLang.g:298:1: ( ( rule__MseStatement__Group__0 ) )
            {
            // InternalTestScenarioLang.g:298:1: ( ( rule__MseStatement__Group__0 ) )
            // InternalTestScenarioLang.g:299:1: ( rule__MseStatement__Group__0 )
            {
             before(grammarAccess.getMseStatementAccess().getGroup()); 
            // InternalTestScenarioLang.g:300:1: ( rule__MseStatement__Group__0 )
            // InternalTestScenarioLang.g:300:2: rule__MseStatement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MseStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMseStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMseStatement"


    // $ANTLR start "entryRuleRewritingRuleCallStatement"
    // InternalTestScenarioLang.g:312:1: entryRuleRewritingRuleCallStatement : ruleRewritingRuleCallStatement EOF ;
    public final void entryRuleRewritingRuleCallStatement() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:313:1: ( ruleRewritingRuleCallStatement EOF )
            // InternalTestScenarioLang.g:314:1: ruleRewritingRuleCallStatement EOF
            {
             before(grammarAccess.getRewritingRuleCallStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRewritingRuleCallStatement();

            state._fsp--;

             after(grammarAccess.getRewritingRuleCallStatementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRewritingRuleCallStatement"


    // $ANTLR start "ruleRewritingRuleCallStatement"
    // InternalTestScenarioLang.g:321:1: ruleRewritingRuleCallStatement : ( ( rule__RewritingRuleCallStatement__Group__0 ) ) ;
    public final void ruleRewritingRuleCallStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:325:2: ( ( ( rule__RewritingRuleCallStatement__Group__0 ) ) )
            // InternalTestScenarioLang.g:326:1: ( ( rule__RewritingRuleCallStatement__Group__0 ) )
            {
            // InternalTestScenarioLang.g:326:1: ( ( rule__RewritingRuleCallStatement__Group__0 ) )
            // InternalTestScenarioLang.g:327:1: ( rule__RewritingRuleCallStatement__Group__0 )
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getGroup()); 
            // InternalTestScenarioLang.g:328:1: ( rule__RewritingRuleCallStatement__Group__0 )
            // InternalTestScenarioLang.g:328:2: rule__RewritingRuleCallStatement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRewritingRuleCallStatement"


    // $ANTLR start "entryRuleVariable"
    // InternalTestScenarioLang.g:340:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:341:1: ( ruleVariable EOF )
            // InternalTestScenarioLang.g:342:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalTestScenarioLang.g:349:1: ruleVariable : ( ( rule__Variable__Alternatives ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:353:2: ( ( ( rule__Variable__Alternatives ) ) )
            // InternalTestScenarioLang.g:354:1: ( ( rule__Variable__Alternatives ) )
            {
            // InternalTestScenarioLang.g:354:1: ( ( rule__Variable__Alternatives ) )
            // InternalTestScenarioLang.g:355:1: ( rule__Variable__Alternatives )
            {
             before(grammarAccess.getVariableAccess().getAlternatives()); 
            // InternalTestScenarioLang.g:356:1: ( rule__Variable__Alternatives )
            // InternalTestScenarioLang.g:356:2: rule__Variable__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Variable__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleEObjectRef"
    // InternalTestScenarioLang.g:368:1: entryRuleEObjectRef : ruleEObjectRef EOF ;
    public final void entryRuleEObjectRef() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:369:1: ( ruleEObjectRef EOF )
            // InternalTestScenarioLang.g:370:1: ruleEObjectRef EOF
            {
             before(grammarAccess.getEObjectRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEObjectRef();

            state._fsp--;

             after(grammarAccess.getEObjectRefRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEObjectRef"


    // $ANTLR start "ruleEObjectRef"
    // InternalTestScenarioLang.g:377:1: ruleEObjectRef : ( ( rule__EObjectRef__ObjectAssignment ) ) ;
    public final void ruleEObjectRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:381:2: ( ( ( rule__EObjectRef__ObjectAssignment ) ) )
            // InternalTestScenarioLang.g:382:1: ( ( rule__EObjectRef__ObjectAssignment ) )
            {
            // InternalTestScenarioLang.g:382:1: ( ( rule__EObjectRef__ObjectAssignment ) )
            // InternalTestScenarioLang.g:383:1: ( rule__EObjectRef__ObjectAssignment )
            {
             before(grammarAccess.getEObjectRefAccess().getObjectAssignment()); 
            // InternalTestScenarioLang.g:384:1: ( rule__EObjectRef__ObjectAssignment )
            // InternalTestScenarioLang.g:384:2: rule__EObjectRef__ObjectAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EObjectRef__ObjectAssignment();

            state._fsp--;


            }

             after(grammarAccess.getEObjectRefAccess().getObjectAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEObjectRef"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalTestScenarioLang.g:396:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:397:1: ( ruleStringLiteral EOF )
            // InternalTestScenarioLang.g:398:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalTestScenarioLang.g:405:1: ruleStringLiteral : ( ( rule__StringLiteral__ValueAssignment ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:409:2: ( ( ( rule__StringLiteral__ValueAssignment ) ) )
            // InternalTestScenarioLang.g:410:1: ( ( rule__StringLiteral__ValueAssignment ) )
            {
            // InternalTestScenarioLang.g:410:1: ( ( rule__StringLiteral__ValueAssignment ) )
            // InternalTestScenarioLang.g:411:1: ( rule__StringLiteral__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment()); 
            // InternalTestScenarioLang.g:412:1: ( rule__StringLiteral__ValueAssignment )
            // InternalTestScenarioLang.g:412:2: rule__StringLiteral__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__StringLiteral__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringLiteralAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleIntegerLiteral"
    // InternalTestScenarioLang.g:424:1: entryRuleIntegerLiteral : ruleIntegerLiteral EOF ;
    public final void entryRuleIntegerLiteral() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:425:1: ( ruleIntegerLiteral EOF )
            // InternalTestScenarioLang.g:426:1: ruleIntegerLiteral EOF
            {
             before(grammarAccess.getIntegerLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleIntegerLiteral();

            state._fsp--;

             after(grammarAccess.getIntegerLiteralRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntegerLiteral"


    // $ANTLR start "ruleIntegerLiteral"
    // InternalTestScenarioLang.g:433:1: ruleIntegerLiteral : ( ( rule__IntegerLiteral__ValueAssignment ) ) ;
    public final void ruleIntegerLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:437:2: ( ( ( rule__IntegerLiteral__ValueAssignment ) ) )
            // InternalTestScenarioLang.g:438:1: ( ( rule__IntegerLiteral__ValueAssignment ) )
            {
            // InternalTestScenarioLang.g:438:1: ( ( rule__IntegerLiteral__ValueAssignment ) )
            // InternalTestScenarioLang.g:439:1: ( rule__IntegerLiteral__ValueAssignment )
            {
             before(grammarAccess.getIntegerLiteralAccess().getValueAssignment()); 
            // InternalTestScenarioLang.g:440:1: ( rule__IntegerLiteral__ValueAssignment )
            // InternalTestScenarioLang.g:440:2: rule__IntegerLiteral__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__IntegerLiteral__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntegerLiteralAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegerLiteral"


    // $ANTLR start "entryRuleEString"
    // InternalTestScenarioLang.g:452:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalTestScenarioLang.g:453:1: ( ruleEString EOF )
            // InternalTestScenarioLang.g:454:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalTestScenarioLang.g:461:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:465:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalTestScenarioLang.g:466:1: ( ( rule__EString__Alternatives ) )
            {
            // InternalTestScenarioLang.g:466:1: ( ( rule__EString__Alternatives ) )
            // InternalTestScenarioLang.g:467:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalTestScenarioLang.g:468:1: ( rule__EString__Alternatives )
            // InternalTestScenarioLang.g:468:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "rule__Scenario__Alternatives_3_0"
    // InternalTestScenarioLang.g:486:1: rule__Scenario__Alternatives_3_0 : ( ( ( rule__Scenario__ModelImportsAssignment_3_0_0 ) ) | ( ( rule__Scenario__ClassImportsAssignment_3_0_1 ) ) );
    public final void rule__Scenario__Alternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:490:1: ( ( ( rule__Scenario__ModelImportsAssignment_3_0_0 ) ) | ( ( rule__Scenario__ClassImportsAssignment_3_0_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=15 && LA1_0<=16)) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalTestScenarioLang.g:491:1: ( ( rule__Scenario__ModelImportsAssignment_3_0_0 ) )
                    {
                    // InternalTestScenarioLang.g:491:1: ( ( rule__Scenario__ModelImportsAssignment_3_0_0 ) )
                    // InternalTestScenarioLang.g:492:1: ( rule__Scenario__ModelImportsAssignment_3_0_0 )
                    {
                     before(grammarAccess.getScenarioAccess().getModelImportsAssignment_3_0_0()); 
                    // InternalTestScenarioLang.g:493:1: ( rule__Scenario__ModelImportsAssignment_3_0_0 )
                    // InternalTestScenarioLang.g:493:2: rule__Scenario__ModelImportsAssignment_3_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario__ModelImportsAssignment_3_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenarioAccess().getModelImportsAssignment_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:497:6: ( ( rule__Scenario__ClassImportsAssignment_3_0_1 ) )
                    {
                    // InternalTestScenarioLang.g:497:6: ( ( rule__Scenario__ClassImportsAssignment_3_0_1 ) )
                    // InternalTestScenarioLang.g:498:1: ( rule__Scenario__ClassImportsAssignment_3_0_1 )
                    {
                     before(grammarAccess.getScenarioAccess().getClassImportsAssignment_3_0_1()); 
                    // InternalTestScenarioLang.g:499:1: ( rule__Scenario__ClassImportsAssignment_3_0_1 )
                    // InternalTestScenarioLang.g:499:2: rule__Scenario__ClassImportsAssignment_3_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario__ClassImportsAssignment_3_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenarioAccess().getClassImportsAssignment_3_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Alternatives_3_0"


    // $ANTLR start "rule__Scenario__Alternatives_3_1"
    // InternalTestScenarioLang.g:508:1: rule__Scenario__Alternatives_3_1 : ( ( ( rule__Scenario__ModelImportsAssignment_3_1_0 ) ) | ( ( rule__Scenario__ClassImportsAssignment_3_1_1 ) ) );
    public final void rule__Scenario__Alternatives_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:512:1: ( ( ( rule__Scenario__ModelImportsAssignment_3_1_0 ) ) | ( ( rule__Scenario__ClassImportsAssignment_3_1_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=15 && LA2_0<=16)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTestScenarioLang.g:513:1: ( ( rule__Scenario__ModelImportsAssignment_3_1_0 ) )
                    {
                    // InternalTestScenarioLang.g:513:1: ( ( rule__Scenario__ModelImportsAssignment_3_1_0 ) )
                    // InternalTestScenarioLang.g:514:1: ( rule__Scenario__ModelImportsAssignment_3_1_0 )
                    {
                     before(grammarAccess.getScenarioAccess().getModelImportsAssignment_3_1_0()); 
                    // InternalTestScenarioLang.g:515:1: ( rule__Scenario__ModelImportsAssignment_3_1_0 )
                    // InternalTestScenarioLang.g:515:2: rule__Scenario__ModelImportsAssignment_3_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario__ModelImportsAssignment_3_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenarioAccess().getModelImportsAssignment_3_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:519:6: ( ( rule__Scenario__ClassImportsAssignment_3_1_1 ) )
                    {
                    // InternalTestScenarioLang.g:519:6: ( ( rule__Scenario__ClassImportsAssignment_3_1_1 ) )
                    // InternalTestScenarioLang.g:520:1: ( rule__Scenario__ClassImportsAssignment_3_1_1 )
                    {
                     before(grammarAccess.getScenarioAccess().getClassImportsAssignment_3_1_1()); 
                    // InternalTestScenarioLang.g:521:1: ( rule__Scenario__ClassImportsAssignment_3_1_1 )
                    // InternalTestScenarioLang.g:521:2: rule__Scenario__ClassImportsAssignment_3_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario__ClassImportsAssignment_3_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getScenarioAccess().getClassImportsAssignment_3_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Alternatives_3_1"


    // $ANTLR start "rule__ImportStatement__Alternatives_2"
    // InternalTestScenarioLang.g:530:1: rule__ImportStatement__Alternatives_2 : ( ( ( rule__ImportStatement__AliasAssignment_2_0 ) ) | ( ( rule__ImportStatement__Group_2_1__0 ) ) );
    public final void rule__ImportStatement__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:534:1: ( ( ( rule__ImportStatement__AliasAssignment_2_0 ) ) | ( ( rule__ImportStatement__Group_2_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalTestScenarioLang.g:535:1: ( ( rule__ImportStatement__AliasAssignment_2_0 ) )
                    {
                    // InternalTestScenarioLang.g:535:1: ( ( rule__ImportStatement__AliasAssignment_2_0 ) )
                    // InternalTestScenarioLang.g:536:1: ( rule__ImportStatement__AliasAssignment_2_0 )
                    {
                     before(grammarAccess.getImportStatementAccess().getAliasAssignment_2_0()); 
                    // InternalTestScenarioLang.g:537:1: ( rule__ImportStatement__AliasAssignment_2_0 )
                    // InternalTestScenarioLang.g:537:2: rule__ImportStatement__AliasAssignment_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ImportStatement__AliasAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportStatementAccess().getAliasAssignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:541:6: ( ( rule__ImportStatement__Group_2_1__0 ) )
                    {
                    // InternalTestScenarioLang.g:541:6: ( ( rule__ImportStatement__Group_2_1__0 ) )
                    // InternalTestScenarioLang.g:542:1: ( rule__ImportStatement__Group_2_1__0 )
                    {
                     before(grammarAccess.getImportStatementAccess().getGroup_2_1()); 
                    // InternalTestScenarioLang.g:543:1: ( rule__ImportStatement__Group_2_1__0 )
                    // InternalTestScenarioLang.g:543:2: rule__ImportStatement__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ImportStatement__Group_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportStatementAccess().getGroup_2_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Alternatives_2"


    // $ANTLR start "rule__ImportJavaStatement__Alternatives_0"
    // InternalTestScenarioLang.g:552:1: rule__ImportJavaStatement__Alternatives_0 : ( ( ( rule__ImportJavaStatement__Group_0_0__0 ) ) | ( ( rule__ImportJavaStatement__Group_0_1__0 ) ) );
    public final void rule__ImportJavaStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:556:1: ( ( ( rule__ImportJavaStatement__Group_0_0__0 ) ) | ( ( rule__ImportJavaStatement__Group_0_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==16) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalTestScenarioLang.g:557:1: ( ( rule__ImportJavaStatement__Group_0_0__0 ) )
                    {
                    // InternalTestScenarioLang.g:557:1: ( ( rule__ImportJavaStatement__Group_0_0__0 ) )
                    // InternalTestScenarioLang.g:558:1: ( rule__ImportJavaStatement__Group_0_0__0 )
                    {
                     before(grammarAccess.getImportJavaStatementAccess().getGroup_0_0()); 
                    // InternalTestScenarioLang.g:559:1: ( rule__ImportJavaStatement__Group_0_0__0 )
                    // InternalTestScenarioLang.g:559:2: rule__ImportJavaStatement__Group_0_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ImportJavaStatement__Group_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportJavaStatementAccess().getGroup_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:563:6: ( ( rule__ImportJavaStatement__Group_0_1__0 ) )
                    {
                    // InternalTestScenarioLang.g:563:6: ( ( rule__ImportJavaStatement__Group_0_1__0 ) )
                    // InternalTestScenarioLang.g:564:1: ( rule__ImportJavaStatement__Group_0_1__0 )
                    {
                     before(grammarAccess.getImportJavaStatementAccess().getGroup_0_1()); 
                    // InternalTestScenarioLang.g:565:1: ( rule__ImportJavaStatement__Group_0_1__0 )
                    // InternalTestScenarioLang.g:565:2: rule__ImportJavaStatement__Group_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ImportJavaStatement__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getImportJavaStatementAccess().getGroup_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Alternatives_0"


    // $ANTLR start "rule__Statement__Alternatives"
    // InternalTestScenarioLang.g:574:1: rule__Statement__Alternatives : ( ( ruleMseStatement ) | ( ruleRewritingRuleCallStatement ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:578:1: ( ( ruleMseStatement ) | ( ruleRewritingRuleCallStatement ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            else if ( (LA5_0==23) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalTestScenarioLang.g:579:1: ( ruleMseStatement )
                    {
                    // InternalTestScenarioLang.g:579:1: ( ruleMseStatement )
                    // InternalTestScenarioLang.g:580:1: ruleMseStatement
                    {
                     before(grammarAccess.getStatementAccess().getMseStatementParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleMseStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getMseStatementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:585:6: ( ruleRewritingRuleCallStatement )
                    {
                    // InternalTestScenarioLang.g:585:6: ( ruleRewritingRuleCallStatement )
                    // InternalTestScenarioLang.g:586:1: ruleRewritingRuleCallStatement
                    {
                     before(grammarAccess.getStatementAccess().getRewritingRuleCallStatementParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRewritingRuleCallStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getRewritingRuleCallStatementParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Alternatives"


    // $ANTLR start "rule__Variable__Alternatives"
    // InternalTestScenarioLang.g:596:1: rule__Variable__Alternatives : ( ( ruleIntegerLiteral ) | ( ruleStringLiteral ) | ( ruleEObjectRef ) );
    public final void rule__Variable__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:600:1: ( ( ruleIntegerLiteral ) | ( ruleStringLiteral ) | ( ruleEObjectRef ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt6=1;
                }
                break;
            case RULE_STRING:
                {
                alt6=2;
                }
                break;
            case RULE_ID:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalTestScenarioLang.g:601:1: ( ruleIntegerLiteral )
                    {
                    // InternalTestScenarioLang.g:601:1: ( ruleIntegerLiteral )
                    // InternalTestScenarioLang.g:602:1: ruleIntegerLiteral
                    {
                     before(grammarAccess.getVariableAccess().getIntegerLiteralParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleIntegerLiteral();

                    state._fsp--;

                     after(grammarAccess.getVariableAccess().getIntegerLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:607:6: ( ruleStringLiteral )
                    {
                    // InternalTestScenarioLang.g:607:6: ( ruleStringLiteral )
                    // InternalTestScenarioLang.g:608:1: ruleStringLiteral
                    {
                     before(grammarAccess.getVariableAccess().getStringLiteralParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleStringLiteral();

                    state._fsp--;

                     after(grammarAccess.getVariableAccess().getStringLiteralParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTestScenarioLang.g:613:6: ( ruleEObjectRef )
                    {
                    // InternalTestScenarioLang.g:613:6: ( ruleEObjectRef )
                    // InternalTestScenarioLang.g:614:1: ruleEObjectRef
                    {
                     before(grammarAccess.getVariableAccess().getEObjectRefParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEObjectRef();

                    state._fsp--;

                     after(grammarAccess.getVariableAccess().getEObjectRefParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalTestScenarioLang.g:624:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:628:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalTestScenarioLang.g:629:1: ( RULE_STRING )
                    {
                    // InternalTestScenarioLang.g:629:1: ( RULE_STRING )
                    // InternalTestScenarioLang.g:630:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:635:6: ( RULE_ID )
                    {
                    // InternalTestScenarioLang.g:635:6: ( RULE_ID )
                    // InternalTestScenarioLang.g:636:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__Scenario__Group__0"
    // InternalTestScenarioLang.g:651:1: rule__Scenario__Group__0 : rule__Scenario__Group__0__Impl rule__Scenario__Group__1 ;
    public final void rule__Scenario__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:655:1: ( rule__Scenario__Group__0__Impl rule__Scenario__Group__1 )
            // InternalTestScenarioLang.g:656:2: rule__Scenario__Group__0__Impl rule__Scenario__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Scenario__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__0"


    // $ANTLR start "rule__Scenario__Group__0__Impl"
    // InternalTestScenarioLang.g:663:1: rule__Scenario__Group__0__Impl : ( () ) ;
    public final void rule__Scenario__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:667:1: ( ( () ) )
            // InternalTestScenarioLang.g:668:1: ( () )
            {
            // InternalTestScenarioLang.g:668:1: ( () )
            // InternalTestScenarioLang.g:669:1: ()
            {
             before(grammarAccess.getScenarioAccess().getScenarioAction_0()); 
            // InternalTestScenarioLang.g:670:1: ()
            // InternalTestScenarioLang.g:672:1: 
            {
            }

             after(grammarAccess.getScenarioAccess().getScenarioAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__0__Impl"


    // $ANTLR start "rule__Scenario__Group__1"
    // InternalTestScenarioLang.g:682:1: rule__Scenario__Group__1 : rule__Scenario__Group__1__Impl rule__Scenario__Group__2 ;
    public final void rule__Scenario__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:686:1: ( rule__Scenario__Group__1__Impl rule__Scenario__Group__2 )
            // InternalTestScenarioLang.g:687:2: rule__Scenario__Group__1__Impl rule__Scenario__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Scenario__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__1"


    // $ANTLR start "rule__Scenario__Group__1__Impl"
    // InternalTestScenarioLang.g:694:1: rule__Scenario__Group__1__Impl : ( 'Scenario' ) ;
    public final void rule__Scenario__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:698:1: ( ( 'Scenario' ) )
            // InternalTestScenarioLang.g:699:1: ( 'Scenario' )
            {
            // InternalTestScenarioLang.g:699:1: ( 'Scenario' )
            // InternalTestScenarioLang.g:700:1: 'Scenario'
            {
             before(grammarAccess.getScenarioAccess().getScenarioKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getScenarioAccess().getScenarioKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__1__Impl"


    // $ANTLR start "rule__Scenario__Group__2"
    // InternalTestScenarioLang.g:713:1: rule__Scenario__Group__2 : rule__Scenario__Group__2__Impl rule__Scenario__Group__3 ;
    public final void rule__Scenario__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:717:1: ( rule__Scenario__Group__2__Impl rule__Scenario__Group__3 )
            // InternalTestScenarioLang.g:718:2: rule__Scenario__Group__2__Impl rule__Scenario__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Scenario__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__2"


    // $ANTLR start "rule__Scenario__Group__2__Impl"
    // InternalTestScenarioLang.g:725:1: rule__Scenario__Group__2__Impl : ( ( rule__Scenario__NameAssignment_2 )? ) ;
    public final void rule__Scenario__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:729:1: ( ( ( rule__Scenario__NameAssignment_2 )? ) )
            // InternalTestScenarioLang.g:730:1: ( ( rule__Scenario__NameAssignment_2 )? )
            {
            // InternalTestScenarioLang.g:730:1: ( ( rule__Scenario__NameAssignment_2 )? )
            // InternalTestScenarioLang.g:731:1: ( rule__Scenario__NameAssignment_2 )?
            {
             before(grammarAccess.getScenarioAccess().getNameAssignment_2()); 
            // InternalTestScenarioLang.g:732:1: ( rule__Scenario__NameAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTestScenarioLang.g:732:2: rule__Scenario__NameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScenarioAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__2__Impl"


    // $ANTLR start "rule__Scenario__Group__3"
    // InternalTestScenarioLang.g:742:1: rule__Scenario__Group__3 : rule__Scenario__Group__3__Impl rule__Scenario__Group__4 ;
    public final void rule__Scenario__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:746:1: ( rule__Scenario__Group__3__Impl rule__Scenario__Group__4 )
            // InternalTestScenarioLang.g:747:2: rule__Scenario__Group__3__Impl rule__Scenario__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Scenario__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__3"


    // $ANTLR start "rule__Scenario__Group__3__Impl"
    // InternalTestScenarioLang.g:754:1: rule__Scenario__Group__3__Impl : ( ( rule__Scenario__Group_3__0 )? ) ;
    public final void rule__Scenario__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:758:1: ( ( ( rule__Scenario__Group_3__0 )? ) )
            // InternalTestScenarioLang.g:759:1: ( ( rule__Scenario__Group_3__0 )? )
            {
            // InternalTestScenarioLang.g:759:1: ( ( rule__Scenario__Group_3__0 )? )
            // InternalTestScenarioLang.g:760:1: ( rule__Scenario__Group_3__0 )?
            {
             before(grammarAccess.getScenarioAccess().getGroup_3()); 
            // InternalTestScenarioLang.g:761:1: ( rule__Scenario__Group_3__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==12||(LA9_0>=15 && LA9_0<=16)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTestScenarioLang.g:761:2: rule__Scenario__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScenarioAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__3__Impl"


    // $ANTLR start "rule__Scenario__Group__4"
    // InternalTestScenarioLang.g:771:1: rule__Scenario__Group__4 : rule__Scenario__Group__4__Impl rule__Scenario__Group__5 ;
    public final void rule__Scenario__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:775:1: ( rule__Scenario__Group__4__Impl rule__Scenario__Group__5 )
            // InternalTestScenarioLang.g:776:2: rule__Scenario__Group__4__Impl rule__Scenario__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Scenario__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__4"


    // $ANTLR start "rule__Scenario__Group__4__Impl"
    // InternalTestScenarioLang.g:783:1: rule__Scenario__Group__4__Impl : ( ( rule__Scenario__Group_4__0 )? ) ;
    public final void rule__Scenario__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:787:1: ( ( ( rule__Scenario__Group_4__0 )? ) )
            // InternalTestScenarioLang.g:788:1: ( ( rule__Scenario__Group_4__0 )? )
            {
            // InternalTestScenarioLang.g:788:1: ( ( rule__Scenario__Group_4__0 )? )
            // InternalTestScenarioLang.g:789:1: ( rule__Scenario__Group_4__0 )?
            {
             before(grammarAccess.getScenarioAccess().getGroup_4()); 
            // InternalTestScenarioLang.g:790:1: ( rule__Scenario__Group_4__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalTestScenarioLang.g:790:2: rule__Scenario__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Scenario__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScenarioAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__4__Impl"


    // $ANTLR start "rule__Scenario__Group__5"
    // InternalTestScenarioLang.g:800:1: rule__Scenario__Group__5 : rule__Scenario__Group__5__Impl ;
    public final void rule__Scenario__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:804:1: ( rule__Scenario__Group__5__Impl )
            // InternalTestScenarioLang.g:805:2: rule__Scenario__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__5"


    // $ANTLR start "rule__Scenario__Group__5__Impl"
    // InternalTestScenarioLang.g:811:1: rule__Scenario__Group__5__Impl : ( ( ( rule__Scenario__StatementSequenceAssignment_5 ) ) ( ( rule__Scenario__StatementSequenceAssignment_5 )* ) ) ;
    public final void rule__Scenario__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:815:1: ( ( ( ( rule__Scenario__StatementSequenceAssignment_5 ) ) ( ( rule__Scenario__StatementSequenceAssignment_5 )* ) ) )
            // InternalTestScenarioLang.g:816:1: ( ( ( rule__Scenario__StatementSequenceAssignment_5 ) ) ( ( rule__Scenario__StatementSequenceAssignment_5 )* ) )
            {
            // InternalTestScenarioLang.g:816:1: ( ( ( rule__Scenario__StatementSequenceAssignment_5 ) ) ( ( rule__Scenario__StatementSequenceAssignment_5 )* ) )
            // InternalTestScenarioLang.g:817:1: ( ( rule__Scenario__StatementSequenceAssignment_5 ) ) ( ( rule__Scenario__StatementSequenceAssignment_5 )* )
            {
            // InternalTestScenarioLang.g:817:1: ( ( rule__Scenario__StatementSequenceAssignment_5 ) )
            // InternalTestScenarioLang.g:818:1: ( rule__Scenario__StatementSequenceAssignment_5 )
            {
             before(grammarAccess.getScenarioAccess().getStatementSequenceAssignment_5()); 
            // InternalTestScenarioLang.g:819:1: ( rule__Scenario__StatementSequenceAssignment_5 )
            // InternalTestScenarioLang.g:819:2: rule__Scenario__StatementSequenceAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Scenario__StatementSequenceAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getScenarioAccess().getStatementSequenceAssignment_5()); 

            }

            // InternalTestScenarioLang.g:822:1: ( ( rule__Scenario__StatementSequenceAssignment_5 )* )
            // InternalTestScenarioLang.g:823:1: ( rule__Scenario__StatementSequenceAssignment_5 )*
            {
             before(grammarAccess.getScenarioAccess().getStatementSequenceAssignment_5()); 
            // InternalTestScenarioLang.g:824:1: ( rule__Scenario__StatementSequenceAssignment_5 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==21||LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalTestScenarioLang.g:824:2: rule__Scenario__StatementSequenceAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Scenario__StatementSequenceAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getScenarioAccess().getStatementSequenceAssignment_5()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group__5__Impl"


    // $ANTLR start "rule__Scenario__Group_3__0"
    // InternalTestScenarioLang.g:847:1: rule__Scenario__Group_3__0 : rule__Scenario__Group_3__0__Impl rule__Scenario__Group_3__1 ;
    public final void rule__Scenario__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:851:1: ( rule__Scenario__Group_3__0__Impl rule__Scenario__Group_3__1 )
            // InternalTestScenarioLang.g:852:2: rule__Scenario__Group_3__0__Impl rule__Scenario__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Scenario__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group_3__0"


    // $ANTLR start "rule__Scenario__Group_3__0__Impl"
    // InternalTestScenarioLang.g:859:1: rule__Scenario__Group_3__0__Impl : ( ( rule__Scenario__Alternatives_3_0 ) ) ;
    public final void rule__Scenario__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:863:1: ( ( ( rule__Scenario__Alternatives_3_0 ) ) )
            // InternalTestScenarioLang.g:864:1: ( ( rule__Scenario__Alternatives_3_0 ) )
            {
            // InternalTestScenarioLang.g:864:1: ( ( rule__Scenario__Alternatives_3_0 ) )
            // InternalTestScenarioLang.g:865:1: ( rule__Scenario__Alternatives_3_0 )
            {
             before(grammarAccess.getScenarioAccess().getAlternatives_3_0()); 
            // InternalTestScenarioLang.g:866:1: ( rule__Scenario__Alternatives_3_0 )
            // InternalTestScenarioLang.g:866:2: rule__Scenario__Alternatives_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Alternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getScenarioAccess().getAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group_3__0__Impl"


    // $ANTLR start "rule__Scenario__Group_3__1"
    // InternalTestScenarioLang.g:876:1: rule__Scenario__Group_3__1 : rule__Scenario__Group_3__1__Impl ;
    public final void rule__Scenario__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:880:1: ( rule__Scenario__Group_3__1__Impl )
            // InternalTestScenarioLang.g:881:2: rule__Scenario__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group_3__1"


    // $ANTLR start "rule__Scenario__Group_3__1__Impl"
    // InternalTestScenarioLang.g:887:1: rule__Scenario__Group_3__1__Impl : ( ( rule__Scenario__Alternatives_3_1 )* ) ;
    public final void rule__Scenario__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:891:1: ( ( ( rule__Scenario__Alternatives_3_1 )* ) )
            // InternalTestScenarioLang.g:892:1: ( ( rule__Scenario__Alternatives_3_1 )* )
            {
            // InternalTestScenarioLang.g:892:1: ( ( rule__Scenario__Alternatives_3_1 )* )
            // InternalTestScenarioLang.g:893:1: ( rule__Scenario__Alternatives_3_1 )*
            {
             before(grammarAccess.getScenarioAccess().getAlternatives_3_1()); 
            // InternalTestScenarioLang.g:894:1: ( rule__Scenario__Alternatives_3_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==12||(LA12_0>=15 && LA12_0<=16)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalTestScenarioLang.g:894:2: rule__Scenario__Alternatives_3_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__Scenario__Alternatives_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getScenarioAccess().getAlternatives_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group_3__1__Impl"


    // $ANTLR start "rule__Scenario__Group_4__0"
    // InternalTestScenarioLang.g:908:1: rule__Scenario__Group_4__0 : rule__Scenario__Group_4__0__Impl rule__Scenario__Group_4__1 ;
    public final void rule__Scenario__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:912:1: ( rule__Scenario__Group_4__0__Impl rule__Scenario__Group_4__1 )
            // InternalTestScenarioLang.g:913:2: rule__Scenario__Group_4__0__Impl rule__Scenario__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Scenario__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group_4__0"


    // $ANTLR start "rule__Scenario__Group_4__0__Impl"
    // InternalTestScenarioLang.g:920:1: rule__Scenario__Group_4__0__Impl : ( ( rule__Scenario__VariablesAssignment_4_0 ) ) ;
    public final void rule__Scenario__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:924:1: ( ( ( rule__Scenario__VariablesAssignment_4_0 ) ) )
            // InternalTestScenarioLang.g:925:1: ( ( rule__Scenario__VariablesAssignment_4_0 ) )
            {
            // InternalTestScenarioLang.g:925:1: ( ( rule__Scenario__VariablesAssignment_4_0 ) )
            // InternalTestScenarioLang.g:926:1: ( rule__Scenario__VariablesAssignment_4_0 )
            {
             before(grammarAccess.getScenarioAccess().getVariablesAssignment_4_0()); 
            // InternalTestScenarioLang.g:927:1: ( rule__Scenario__VariablesAssignment_4_0 )
            // InternalTestScenarioLang.g:927:2: rule__Scenario__VariablesAssignment_4_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__VariablesAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getScenarioAccess().getVariablesAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group_4__0__Impl"


    // $ANTLR start "rule__Scenario__Group_4__1"
    // InternalTestScenarioLang.g:937:1: rule__Scenario__Group_4__1 : rule__Scenario__Group_4__1__Impl ;
    public final void rule__Scenario__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:941:1: ( rule__Scenario__Group_4__1__Impl )
            // InternalTestScenarioLang.g:942:2: rule__Scenario__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Scenario__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group_4__1"


    // $ANTLR start "rule__Scenario__Group_4__1__Impl"
    // InternalTestScenarioLang.g:948:1: rule__Scenario__Group_4__1__Impl : ( ( rule__Scenario__VariablesAssignment_4_1 )* ) ;
    public final void rule__Scenario__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:952:1: ( ( ( rule__Scenario__VariablesAssignment_4_1 )* ) )
            // InternalTestScenarioLang.g:953:1: ( ( rule__Scenario__VariablesAssignment_4_1 )* )
            {
            // InternalTestScenarioLang.g:953:1: ( ( rule__Scenario__VariablesAssignment_4_1 )* )
            // InternalTestScenarioLang.g:954:1: ( rule__Scenario__VariablesAssignment_4_1 )*
            {
             before(grammarAccess.getScenarioAccess().getVariablesAssignment_4_1()); 
            // InternalTestScenarioLang.g:955:1: ( rule__Scenario__VariablesAssignment_4_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==17) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalTestScenarioLang.g:955:2: rule__Scenario__VariablesAssignment_4_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_9);
            	    rule__Scenario__VariablesAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getScenarioAccess().getVariablesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__Group_4__1__Impl"


    // $ANTLR start "rule__ImportStatement__Group__0"
    // InternalTestScenarioLang.g:969:1: rule__ImportStatement__Group__0 : rule__ImportStatement__Group__0__Impl rule__ImportStatement__Group__1 ;
    public final void rule__ImportStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:973:1: ( rule__ImportStatement__Group__0__Impl rule__ImportStatement__Group__1 )
            // InternalTestScenarioLang.g:974:2: rule__ImportStatement__Group__0__Impl rule__ImportStatement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__ImportStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__0"


    // $ANTLR start "rule__ImportStatement__Group__0__Impl"
    // InternalTestScenarioLang.g:981:1: rule__ImportStatement__Group__0__Impl : ( 'importModel' ) ;
    public final void rule__ImportStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:985:1: ( ( 'importModel' ) )
            // InternalTestScenarioLang.g:986:1: ( 'importModel' )
            {
            // InternalTestScenarioLang.g:986:1: ( 'importModel' )
            // InternalTestScenarioLang.g:987:1: 'importModel'
            {
             before(grammarAccess.getImportStatementAccess().getImportModelKeyword_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportStatementAccess().getImportModelKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__0__Impl"


    // $ANTLR start "rule__ImportStatement__Group__1"
    // InternalTestScenarioLang.g:1000:1: rule__ImportStatement__Group__1 : rule__ImportStatement__Group__1__Impl rule__ImportStatement__Group__2 ;
    public final void rule__ImportStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1004:1: ( rule__ImportStatement__Group__1__Impl rule__ImportStatement__Group__2 )
            // InternalTestScenarioLang.g:1005:2: rule__ImportStatement__Group__1__Impl rule__ImportStatement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ImportStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__1"


    // $ANTLR start "rule__ImportStatement__Group__1__Impl"
    // InternalTestScenarioLang.g:1012:1: rule__ImportStatement__Group__1__Impl : ( ( rule__ImportStatement__ImportURIAssignment_1 ) ) ;
    public final void rule__ImportStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1016:1: ( ( ( rule__ImportStatement__ImportURIAssignment_1 ) ) )
            // InternalTestScenarioLang.g:1017:1: ( ( rule__ImportStatement__ImportURIAssignment_1 ) )
            {
            // InternalTestScenarioLang.g:1017:1: ( ( rule__ImportStatement__ImportURIAssignment_1 ) )
            // InternalTestScenarioLang.g:1018:1: ( rule__ImportStatement__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportStatementAccess().getImportURIAssignment_1()); 
            // InternalTestScenarioLang.g:1019:1: ( rule__ImportStatement__ImportURIAssignment_1 )
            // InternalTestScenarioLang.g:1019:2: rule__ImportStatement__ImportURIAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportStatement__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportStatementAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__1__Impl"


    // $ANTLR start "rule__ImportStatement__Group__2"
    // InternalTestScenarioLang.g:1029:1: rule__ImportStatement__Group__2 : rule__ImportStatement__Group__2__Impl ;
    public final void rule__ImportStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1033:1: ( rule__ImportStatement__Group__2__Impl )
            // InternalTestScenarioLang.g:1034:2: rule__ImportStatement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportStatement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__2"


    // $ANTLR start "rule__ImportStatement__Group__2__Impl"
    // InternalTestScenarioLang.g:1040:1: rule__ImportStatement__Group__2__Impl : ( ( rule__ImportStatement__Alternatives_2 ) ) ;
    public final void rule__ImportStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1044:1: ( ( ( rule__ImportStatement__Alternatives_2 ) ) )
            // InternalTestScenarioLang.g:1045:1: ( ( rule__ImportStatement__Alternatives_2 ) )
            {
            // InternalTestScenarioLang.g:1045:1: ( ( rule__ImportStatement__Alternatives_2 ) )
            // InternalTestScenarioLang.g:1046:1: ( rule__ImportStatement__Alternatives_2 )
            {
             before(grammarAccess.getImportStatementAccess().getAlternatives_2()); 
            // InternalTestScenarioLang.g:1047:1: ( rule__ImportStatement__Alternatives_2 )
            // InternalTestScenarioLang.g:1047:2: rule__ImportStatement__Alternatives_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportStatement__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getImportStatementAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group__2__Impl"


    // $ANTLR start "rule__ImportStatement__Group_2_1__0"
    // InternalTestScenarioLang.g:1063:1: rule__ImportStatement__Group_2_1__0 : rule__ImportStatement__Group_2_1__0__Impl rule__ImportStatement__Group_2_1__1 ;
    public final void rule__ImportStatement__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1067:1: ( rule__ImportStatement__Group_2_1__0__Impl rule__ImportStatement__Group_2_1__1 )
            // InternalTestScenarioLang.g:1068:2: rule__ImportStatement__Group_2_1__0__Impl rule__ImportStatement__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__ImportStatement__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportStatement__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group_2_1__0"


    // $ANTLR start "rule__ImportStatement__Group_2_1__0__Impl"
    // InternalTestScenarioLang.g:1075:1: rule__ImportStatement__Group_2_1__0__Impl : ( 'as' ) ;
    public final void rule__ImportStatement__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1079:1: ( ( 'as' ) )
            // InternalTestScenarioLang.g:1080:1: ( 'as' )
            {
            // InternalTestScenarioLang.g:1080:1: ( 'as' )
            // InternalTestScenarioLang.g:1081:1: 'as'
            {
             before(grammarAccess.getImportStatementAccess().getAsKeyword_2_1_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportStatementAccess().getAsKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group_2_1__0__Impl"


    // $ANTLR start "rule__ImportStatement__Group_2_1__1"
    // InternalTestScenarioLang.g:1094:1: rule__ImportStatement__Group_2_1__1 : rule__ImportStatement__Group_2_1__1__Impl rule__ImportStatement__Group_2_1__2 ;
    public final void rule__ImportStatement__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1098:1: ( rule__ImportStatement__Group_2_1__1__Impl rule__ImportStatement__Group_2_1__2 )
            // InternalTestScenarioLang.g:1099:2: rule__ImportStatement__Group_2_1__1__Impl rule__ImportStatement__Group_2_1__2
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__ImportStatement__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportStatement__Group_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group_2_1__1"


    // $ANTLR start "rule__ImportStatement__Group_2_1__1__Impl"
    // InternalTestScenarioLang.g:1106:1: rule__ImportStatement__Group_2_1__1__Impl : ( ( rule__ImportStatement__AliasAssignment_2_1_1 ) ) ;
    public final void rule__ImportStatement__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1110:1: ( ( ( rule__ImportStatement__AliasAssignment_2_1_1 ) ) )
            // InternalTestScenarioLang.g:1111:1: ( ( rule__ImportStatement__AliasAssignment_2_1_1 ) )
            {
            // InternalTestScenarioLang.g:1111:1: ( ( rule__ImportStatement__AliasAssignment_2_1_1 ) )
            // InternalTestScenarioLang.g:1112:1: ( rule__ImportStatement__AliasAssignment_2_1_1 )
            {
             before(grammarAccess.getImportStatementAccess().getAliasAssignment_2_1_1()); 
            // InternalTestScenarioLang.g:1113:1: ( rule__ImportStatement__AliasAssignment_2_1_1 )
            // InternalTestScenarioLang.g:1113:2: rule__ImportStatement__AliasAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportStatement__AliasAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getImportStatementAccess().getAliasAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group_2_1__1__Impl"


    // $ANTLR start "rule__ImportStatement__Group_2_1__2"
    // InternalTestScenarioLang.g:1123:1: rule__ImportStatement__Group_2_1__2 : rule__ImportStatement__Group_2_1__2__Impl ;
    public final void rule__ImportStatement__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1127:1: ( rule__ImportStatement__Group_2_1__2__Impl )
            // InternalTestScenarioLang.g:1128:2: rule__ImportStatement__Group_2_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportStatement__Group_2_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group_2_1__2"


    // $ANTLR start "rule__ImportStatement__Group_2_1__2__Impl"
    // InternalTestScenarioLang.g:1134:1: rule__ImportStatement__Group_2_1__2__Impl : ( ';' ) ;
    public final void rule__ImportStatement__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1138:1: ( ( ';' ) )
            // InternalTestScenarioLang.g:1139:1: ( ';' )
            {
            // InternalTestScenarioLang.g:1139:1: ( ';' )
            // InternalTestScenarioLang.g:1140:1: ';'
            {
             before(grammarAccess.getImportStatementAccess().getSemicolonKeyword_2_1_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportStatementAccess().getSemicolonKeyword_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__Group_2_1__2__Impl"


    // $ANTLR start "rule__ImportJavaStatement__Group__0"
    // InternalTestScenarioLang.g:1159:1: rule__ImportJavaStatement__Group__0 : rule__ImportJavaStatement__Group__0__Impl rule__ImportJavaStatement__Group__1 ;
    public final void rule__ImportJavaStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1163:1: ( rule__ImportJavaStatement__Group__0__Impl rule__ImportJavaStatement__Group__1 )
            // InternalTestScenarioLang.g:1164:2: rule__ImportJavaStatement__Group__0__Impl rule__ImportJavaStatement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__ImportJavaStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportJavaStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group__0"


    // $ANTLR start "rule__ImportJavaStatement__Group__0__Impl"
    // InternalTestScenarioLang.g:1171:1: rule__ImportJavaStatement__Group__0__Impl : ( ( rule__ImportJavaStatement__Alternatives_0 ) ) ;
    public final void rule__ImportJavaStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1175:1: ( ( ( rule__ImportJavaStatement__Alternatives_0 ) ) )
            // InternalTestScenarioLang.g:1176:1: ( ( rule__ImportJavaStatement__Alternatives_0 ) )
            {
            // InternalTestScenarioLang.g:1176:1: ( ( rule__ImportJavaStatement__Alternatives_0 ) )
            // InternalTestScenarioLang.g:1177:1: ( rule__ImportJavaStatement__Alternatives_0 )
            {
             before(grammarAccess.getImportJavaStatementAccess().getAlternatives_0()); 
            // InternalTestScenarioLang.g:1178:1: ( rule__ImportJavaStatement__Alternatives_0 )
            // InternalTestScenarioLang.g:1178:2: rule__ImportJavaStatement__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportJavaStatement__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getImportJavaStatementAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group__0__Impl"


    // $ANTLR start "rule__ImportJavaStatement__Group__1"
    // InternalTestScenarioLang.g:1188:1: rule__ImportJavaStatement__Group__1 : rule__ImportJavaStatement__Group__1__Impl ;
    public final void rule__ImportJavaStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1192:1: ( rule__ImportJavaStatement__Group__1__Impl )
            // InternalTestScenarioLang.g:1193:2: rule__ImportJavaStatement__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportJavaStatement__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group__1"


    // $ANTLR start "rule__ImportJavaStatement__Group__1__Impl"
    // InternalTestScenarioLang.g:1199:1: rule__ImportJavaStatement__Group__1__Impl : ( ';' ) ;
    public final void rule__ImportJavaStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1203:1: ( ( ';' ) )
            // InternalTestScenarioLang.g:1204:1: ( ';' )
            {
            // InternalTestScenarioLang.g:1204:1: ( ';' )
            // InternalTestScenarioLang.g:1205:1: ';'
            {
             before(grammarAccess.getImportJavaStatementAccess().getSemicolonKeyword_1()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportJavaStatementAccess().getSemicolonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group__1__Impl"


    // $ANTLR start "rule__ImportJavaStatement__Group_0_0__0"
    // InternalTestScenarioLang.g:1222:1: rule__ImportJavaStatement__Group_0_0__0 : rule__ImportJavaStatement__Group_0_0__0__Impl rule__ImportJavaStatement__Group_0_0__1 ;
    public final void rule__ImportJavaStatement__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1226:1: ( rule__ImportJavaStatement__Group_0_0__0__Impl rule__ImportJavaStatement__Group_0_0__1 )
            // InternalTestScenarioLang.g:1227:2: rule__ImportJavaStatement__Group_0_0__0__Impl rule__ImportJavaStatement__Group_0_0__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__ImportJavaStatement__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportJavaStatement__Group_0_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group_0_0__0"


    // $ANTLR start "rule__ImportJavaStatement__Group_0_0__0__Impl"
    // InternalTestScenarioLang.g:1234:1: rule__ImportJavaStatement__Group_0_0__0__Impl : ( 'importClass' ) ;
    public final void rule__ImportJavaStatement__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1238:1: ( ( 'importClass' ) )
            // InternalTestScenarioLang.g:1239:1: ( 'importClass' )
            {
            // InternalTestScenarioLang.g:1239:1: ( 'importClass' )
            // InternalTestScenarioLang.g:1240:1: 'importClass'
            {
             before(grammarAccess.getImportJavaStatementAccess().getImportClassKeyword_0_0_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportJavaStatementAccess().getImportClassKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group_0_0__0__Impl"


    // $ANTLR start "rule__ImportJavaStatement__Group_0_0__1"
    // InternalTestScenarioLang.g:1253:1: rule__ImportJavaStatement__Group_0_0__1 : rule__ImportJavaStatement__Group_0_0__1__Impl ;
    public final void rule__ImportJavaStatement__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1257:1: ( rule__ImportJavaStatement__Group_0_0__1__Impl )
            // InternalTestScenarioLang.g:1258:2: rule__ImportJavaStatement__Group_0_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportJavaStatement__Group_0_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group_0_0__1"


    // $ANTLR start "rule__ImportJavaStatement__Group_0_0__1__Impl"
    // InternalTestScenarioLang.g:1264:1: rule__ImportJavaStatement__Group_0_0__1__Impl : ( ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1 ) ) ;
    public final void rule__ImportJavaStatement__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1268:1: ( ( ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1 ) ) )
            // InternalTestScenarioLang.g:1269:1: ( ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1 ) )
            {
            // InternalTestScenarioLang.g:1269:1: ( ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1 ) )
            // InternalTestScenarioLang.g:1270:1: ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1 )
            {
             before(grammarAccess.getImportJavaStatementAccess().getImportedNamespaceAssignment_0_0_1()); 
            // InternalTestScenarioLang.g:1271:1: ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1 )
            // InternalTestScenarioLang.g:1271:2: rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1();

            state._fsp--;


            }

             after(grammarAccess.getImportJavaStatementAccess().getImportedNamespaceAssignment_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group_0_0__1__Impl"


    // $ANTLR start "rule__ImportJavaStatement__Group_0_1__0"
    // InternalTestScenarioLang.g:1285:1: rule__ImportJavaStatement__Group_0_1__0 : rule__ImportJavaStatement__Group_0_1__0__Impl rule__ImportJavaStatement__Group_0_1__1 ;
    public final void rule__ImportJavaStatement__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1289:1: ( rule__ImportJavaStatement__Group_0_1__0__Impl rule__ImportJavaStatement__Group_0_1__1 )
            // InternalTestScenarioLang.g:1290:2: rule__ImportJavaStatement__Group_0_1__0__Impl rule__ImportJavaStatement__Group_0_1__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__ImportJavaStatement__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportJavaStatement__Group_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group_0_1__0"


    // $ANTLR start "rule__ImportJavaStatement__Group_0_1__0__Impl"
    // InternalTestScenarioLang.g:1297:1: rule__ImportJavaStatement__Group_0_1__0__Impl : ( 'importPackage' ) ;
    public final void rule__ImportJavaStatement__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1301:1: ( ( 'importPackage' ) )
            // InternalTestScenarioLang.g:1302:1: ( 'importPackage' )
            {
            // InternalTestScenarioLang.g:1302:1: ( 'importPackage' )
            // InternalTestScenarioLang.g:1303:1: 'importPackage'
            {
             before(grammarAccess.getImportJavaStatementAccess().getImportPackageKeyword_0_1_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportJavaStatementAccess().getImportPackageKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group_0_1__0__Impl"


    // $ANTLR start "rule__ImportJavaStatement__Group_0_1__1"
    // InternalTestScenarioLang.g:1316:1: rule__ImportJavaStatement__Group_0_1__1 : rule__ImportJavaStatement__Group_0_1__1__Impl ;
    public final void rule__ImportJavaStatement__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1320:1: ( rule__ImportJavaStatement__Group_0_1__1__Impl )
            // InternalTestScenarioLang.g:1321:2: rule__ImportJavaStatement__Group_0_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportJavaStatement__Group_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group_0_1__1"


    // $ANTLR start "rule__ImportJavaStatement__Group_0_1__1__Impl"
    // InternalTestScenarioLang.g:1327:1: rule__ImportJavaStatement__Group_0_1__1__Impl : ( ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1 ) ) ;
    public final void rule__ImportJavaStatement__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1331:1: ( ( ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1 ) ) )
            // InternalTestScenarioLang.g:1332:1: ( ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1 ) )
            {
            // InternalTestScenarioLang.g:1332:1: ( ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1 ) )
            // InternalTestScenarioLang.g:1333:1: ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1 )
            {
             before(grammarAccess.getImportJavaStatementAccess().getImportedNamespaceAssignment_0_1_1()); 
            // InternalTestScenarioLang.g:1334:1: ( rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1 )
            // InternalTestScenarioLang.g:1334:2: rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getImportJavaStatementAccess().getImportedNamespaceAssignment_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__Group_0_1__1__Impl"


    // $ANTLR start "rule__ObjectVariable__Group__0"
    // InternalTestScenarioLang.g:1348:1: rule__ObjectVariable__Group__0 : rule__ObjectVariable__Group__0__Impl rule__ObjectVariable__Group__1 ;
    public final void rule__ObjectVariable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1352:1: ( rule__ObjectVariable__Group__0__Impl rule__ObjectVariable__Group__1 )
            // InternalTestScenarioLang.g:1353:2: rule__ObjectVariable__Group__0__Impl rule__ObjectVariable__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__ObjectVariable__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ObjectVariable__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__Group__0"


    // $ANTLR start "rule__ObjectVariable__Group__0__Impl"
    // InternalTestScenarioLang.g:1360:1: rule__ObjectVariable__Group__0__Impl : ( 'Variable' ) ;
    public final void rule__ObjectVariable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1364:1: ( ( 'Variable' ) )
            // InternalTestScenarioLang.g:1365:1: ( 'Variable' )
            {
            // InternalTestScenarioLang.g:1365:1: ( 'Variable' )
            // InternalTestScenarioLang.g:1366:1: 'Variable'
            {
             before(grammarAccess.getObjectVariableAccess().getVariableKeyword_0()); 
            match(input,17,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getObjectVariableAccess().getVariableKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__Group__0__Impl"


    // $ANTLR start "rule__ObjectVariable__Group__1"
    // InternalTestScenarioLang.g:1379:1: rule__ObjectVariable__Group__1 : rule__ObjectVariable__Group__1__Impl rule__ObjectVariable__Group__2 ;
    public final void rule__ObjectVariable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1383:1: ( rule__ObjectVariable__Group__1__Impl rule__ObjectVariable__Group__2 )
            // InternalTestScenarioLang.g:1384:2: rule__ObjectVariable__Group__1__Impl rule__ObjectVariable__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__ObjectVariable__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ObjectVariable__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__Group__1"


    // $ANTLR start "rule__ObjectVariable__Group__1__Impl"
    // InternalTestScenarioLang.g:1391:1: rule__ObjectVariable__Group__1__Impl : ( ( rule__ObjectVariable__NameAssignment_1 ) ) ;
    public final void rule__ObjectVariable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1395:1: ( ( ( rule__ObjectVariable__NameAssignment_1 ) ) )
            // InternalTestScenarioLang.g:1396:1: ( ( rule__ObjectVariable__NameAssignment_1 ) )
            {
            // InternalTestScenarioLang.g:1396:1: ( ( rule__ObjectVariable__NameAssignment_1 ) )
            // InternalTestScenarioLang.g:1397:1: ( rule__ObjectVariable__NameAssignment_1 )
            {
             before(grammarAccess.getObjectVariableAccess().getNameAssignment_1()); 
            // InternalTestScenarioLang.g:1398:1: ( rule__ObjectVariable__NameAssignment_1 )
            // InternalTestScenarioLang.g:1398:2: rule__ObjectVariable__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ObjectVariable__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getObjectVariableAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__Group__1__Impl"


    // $ANTLR start "rule__ObjectVariable__Group__2"
    // InternalTestScenarioLang.g:1408:1: rule__ObjectVariable__Group__2 : rule__ObjectVariable__Group__2__Impl rule__ObjectVariable__Group__3 ;
    public final void rule__ObjectVariable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1412:1: ( rule__ObjectVariable__Group__2__Impl rule__ObjectVariable__Group__3 )
            // InternalTestScenarioLang.g:1413:2: rule__ObjectVariable__Group__2__Impl rule__ObjectVariable__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__ObjectVariable__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ObjectVariable__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__Group__2"


    // $ANTLR start "rule__ObjectVariable__Group__2__Impl"
    // InternalTestScenarioLang.g:1420:1: rule__ObjectVariable__Group__2__Impl : ( ':' ) ;
    public final void rule__ObjectVariable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1424:1: ( ( ':' ) )
            // InternalTestScenarioLang.g:1425:1: ( ':' )
            {
            // InternalTestScenarioLang.g:1425:1: ( ':' )
            // InternalTestScenarioLang.g:1426:1: ':'
            {
             before(grammarAccess.getObjectVariableAccess().getColonKeyword_2()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getObjectVariableAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__Group__2__Impl"


    // $ANTLR start "rule__ObjectVariable__Group__3"
    // InternalTestScenarioLang.g:1439:1: rule__ObjectVariable__Group__3 : rule__ObjectVariable__Group__3__Impl rule__ObjectVariable__Group__4 ;
    public final void rule__ObjectVariable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1443:1: ( rule__ObjectVariable__Group__3__Impl rule__ObjectVariable__Group__4 )
            // InternalTestScenarioLang.g:1444:2: rule__ObjectVariable__Group__3__Impl rule__ObjectVariable__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__ObjectVariable__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ObjectVariable__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__Group__3"


    // $ANTLR start "rule__ObjectVariable__Group__3__Impl"
    // InternalTestScenarioLang.g:1451:1: rule__ObjectVariable__Group__3__Impl : ( ( rule__ObjectVariable__TypeAssignment_3 ) ) ;
    public final void rule__ObjectVariable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1455:1: ( ( ( rule__ObjectVariable__TypeAssignment_3 ) ) )
            // InternalTestScenarioLang.g:1456:1: ( ( rule__ObjectVariable__TypeAssignment_3 ) )
            {
            // InternalTestScenarioLang.g:1456:1: ( ( rule__ObjectVariable__TypeAssignment_3 ) )
            // InternalTestScenarioLang.g:1457:1: ( rule__ObjectVariable__TypeAssignment_3 )
            {
             before(grammarAccess.getObjectVariableAccess().getTypeAssignment_3()); 
            // InternalTestScenarioLang.g:1458:1: ( rule__ObjectVariable__TypeAssignment_3 )
            // InternalTestScenarioLang.g:1458:2: rule__ObjectVariable__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ObjectVariable__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getObjectVariableAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__Group__3__Impl"


    // $ANTLR start "rule__ObjectVariable__Group__4"
    // InternalTestScenarioLang.g:1468:1: rule__ObjectVariable__Group__4 : rule__ObjectVariable__Group__4__Impl ;
    public final void rule__ObjectVariable__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1472:1: ( rule__ObjectVariable__Group__4__Impl )
            // InternalTestScenarioLang.g:1473:2: rule__ObjectVariable__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ObjectVariable__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__Group__4"


    // $ANTLR start "rule__ObjectVariable__Group__4__Impl"
    // InternalTestScenarioLang.g:1479:1: rule__ObjectVariable__Group__4__Impl : ( ';' ) ;
    public final void rule__ObjectVariable__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1483:1: ( ( ';' ) )
            // InternalTestScenarioLang.g:1484:1: ( ';' )
            {
            // InternalTestScenarioLang.g:1484:1: ( ';' )
            // InternalTestScenarioLang.g:1485:1: ';'
            {
             before(grammarAccess.getObjectVariableAccess().getSemicolonKeyword_4()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getObjectVariableAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__Group__4__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__0"
    // InternalTestScenarioLang.g:1508:1: rule__QualifiedNameWithWildCard__Group__0 : rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 ;
    public final void rule__QualifiedNameWithWildCard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1512:1: ( rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 )
            // InternalTestScenarioLang.g:1513:2: rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__QualifiedNameWithWildCard__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedNameWithWildCard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__0"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__0__Impl"
    // InternalTestScenarioLang.g:1520:1: rule__QualifiedNameWithWildCard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildCard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1524:1: ( ( ruleQualifiedName ) )
            // InternalTestScenarioLang.g:1525:1: ( ruleQualifiedName )
            {
            // InternalTestScenarioLang.g:1525:1: ( ruleQualifiedName )
            // InternalTestScenarioLang.g:1526:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__1"
    // InternalTestScenarioLang.g:1537:1: rule__QualifiedNameWithWildCard__Group__1 : rule__QualifiedNameWithWildCard__Group__1__Impl rule__QualifiedNameWithWildCard__Group__2 ;
    public final void rule__QualifiedNameWithWildCard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1541:1: ( rule__QualifiedNameWithWildCard__Group__1__Impl rule__QualifiedNameWithWildCard__Group__2 )
            // InternalTestScenarioLang.g:1542:2: rule__QualifiedNameWithWildCard__Group__1__Impl rule__QualifiedNameWithWildCard__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__QualifiedNameWithWildCard__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedNameWithWildCard__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__1"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__1__Impl"
    // InternalTestScenarioLang.g:1549:1: rule__QualifiedNameWithWildCard__Group__1__Impl : ( '.' ) ;
    public final void rule__QualifiedNameWithWildCard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1553:1: ( ( '.' ) )
            // InternalTestScenarioLang.g:1554:1: ( '.' )
            {
            // InternalTestScenarioLang.g:1554:1: ( '.' )
            // InternalTestScenarioLang.g:1555:1: '.'
            {
             before(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__2"
    // InternalTestScenarioLang.g:1568:1: rule__QualifiedNameWithWildCard__Group__2 : rule__QualifiedNameWithWildCard__Group__2__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1572:1: ( rule__QualifiedNameWithWildCard__Group__2__Impl )
            // InternalTestScenarioLang.g:1573:2: rule__QualifiedNameWithWildCard__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedNameWithWildCard__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__2"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__2__Impl"
    // InternalTestScenarioLang.g:1579:1: rule__QualifiedNameWithWildCard__Group__2__Impl : ( '*' ) ;
    public final void rule__QualifiedNameWithWildCard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1583:1: ( ( '*' ) )
            // InternalTestScenarioLang.g:1584:1: ( '*' )
            {
            // InternalTestScenarioLang.g:1584:1: ( '*' )
            // InternalTestScenarioLang.g:1585:1: '*'
            {
             before(grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_2()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__2__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalTestScenarioLang.g:1604:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1608:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalTestScenarioLang.g:1609:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalTestScenarioLang.g:1616:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1620:1: ( ( RULE_ID ) )
            // InternalTestScenarioLang.g:1621:1: ( RULE_ID )
            {
            // InternalTestScenarioLang.g:1621:1: ( RULE_ID )
            // InternalTestScenarioLang.g:1622:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalTestScenarioLang.g:1633:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1637:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalTestScenarioLang.g:1638:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalTestScenarioLang.g:1644:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1648:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalTestScenarioLang.g:1649:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalTestScenarioLang.g:1649:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalTestScenarioLang.g:1650:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalTestScenarioLang.g:1651:1: ( rule__QualifiedName__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==19) ) {
                    int LA14_2 = input.LA(2);

                    if ( (LA14_2==RULE_ID) ) {
                        alt14=1;
                    }


                }


                switch (alt14) {
            	case 1 :
            	    // InternalTestScenarioLang.g:1651:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_17);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalTestScenarioLang.g:1665:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1669:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalTestScenarioLang.g:1670:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalTestScenarioLang.g:1677:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1681:1: ( ( '.' ) )
            // InternalTestScenarioLang.g:1682:1: ( '.' )
            {
            // InternalTestScenarioLang.g:1682:1: ( '.' )
            // InternalTestScenarioLang.g:1683:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalTestScenarioLang.g:1696:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1700:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalTestScenarioLang.g:1701:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalTestScenarioLang.g:1707:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1711:1: ( ( RULE_ID ) )
            // InternalTestScenarioLang.g:1712:1: ( RULE_ID )
            {
            // InternalTestScenarioLang.g:1712:1: ( RULE_ID )
            // InternalTestScenarioLang.g:1713:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group__0"
    // InternalTestScenarioLang.g:1728:1: rule__JvmTypeReference__Group__0 : rule__JvmTypeReference__Group__0__Impl rule__JvmTypeReference__Group__1 ;
    public final void rule__JvmTypeReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1732:1: ( rule__JvmTypeReference__Group__0__Impl rule__JvmTypeReference__Group__1 )
            // InternalTestScenarioLang.g:1733:2: rule__JvmTypeReference__Group__0__Impl rule__JvmTypeReference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__JvmTypeReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__JvmTypeReference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group__0"


    // $ANTLR start "rule__JvmTypeReference__Group__0__Impl"
    // InternalTestScenarioLang.g:1740:1: rule__JvmTypeReference__Group__0__Impl : ( () ) ;
    public final void rule__JvmTypeReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1744:1: ( ( () ) )
            // InternalTestScenarioLang.g:1745:1: ( () )
            {
            // InternalTestScenarioLang.g:1745:1: ( () )
            // InternalTestScenarioLang.g:1746:1: ()
            {
             before(grammarAccess.getJvmTypeReferenceAccess().getJvmAnyTypeReferenceAction_0()); 
            // InternalTestScenarioLang.g:1747:1: ()
            // InternalTestScenarioLang.g:1749:1: 
            {
            }

             after(grammarAccess.getJvmTypeReferenceAccess().getJvmAnyTypeReferenceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group__0__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group__1"
    // InternalTestScenarioLang.g:1759:1: rule__JvmTypeReference__Group__1 : rule__JvmTypeReference__Group__1__Impl ;
    public final void rule__JvmTypeReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1763:1: ( rule__JvmTypeReference__Group__1__Impl )
            // InternalTestScenarioLang.g:1764:2: rule__JvmTypeReference__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__JvmTypeReference__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group__1"


    // $ANTLR start "rule__JvmTypeReference__Group__1__Impl"
    // InternalTestScenarioLang.g:1770:1: rule__JvmTypeReference__Group__1__Impl : ( ( rule__JvmTypeReference__TypeAssignment_1 ) ) ;
    public final void rule__JvmTypeReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1774:1: ( ( ( rule__JvmTypeReference__TypeAssignment_1 ) ) )
            // InternalTestScenarioLang.g:1775:1: ( ( rule__JvmTypeReference__TypeAssignment_1 ) )
            {
            // InternalTestScenarioLang.g:1775:1: ( ( rule__JvmTypeReference__TypeAssignment_1 ) )
            // InternalTestScenarioLang.g:1776:1: ( rule__JvmTypeReference__TypeAssignment_1 )
            {
             before(grammarAccess.getJvmTypeReferenceAccess().getTypeAssignment_1()); 
            // InternalTestScenarioLang.g:1777:1: ( rule__JvmTypeReference__TypeAssignment_1 )
            // InternalTestScenarioLang.g:1777:2: rule__JvmTypeReference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__JvmTypeReference__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJvmTypeReferenceAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group__1__Impl"


    // $ANTLR start "rule__MseStatement__Group__0"
    // InternalTestScenarioLang.g:1791:1: rule__MseStatement__Group__0 : rule__MseStatement__Group__0__Impl rule__MseStatement__Group__1 ;
    public final void rule__MseStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1795:1: ( rule__MseStatement__Group__0__Impl rule__MseStatement__Group__1 )
            // InternalTestScenarioLang.g:1796:2: rule__MseStatement__Group__0__Impl rule__MseStatement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MseStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MseStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group__0"


    // $ANTLR start "rule__MseStatement__Group__0__Impl"
    // InternalTestScenarioLang.g:1803:1: rule__MseStatement__Group__0__Impl : ( 'expect' ) ;
    public final void rule__MseStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1807:1: ( ( 'expect' ) )
            // InternalTestScenarioLang.g:1808:1: ( 'expect' )
            {
            // InternalTestScenarioLang.g:1808:1: ( 'expect' )
            // InternalTestScenarioLang.g:1809:1: 'expect'
            {
             before(grammarAccess.getMseStatementAccess().getExpectKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMseStatementAccess().getExpectKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group__0__Impl"


    // $ANTLR start "rule__MseStatement__Group__1"
    // InternalTestScenarioLang.g:1822:1: rule__MseStatement__Group__1 : rule__MseStatement__Group__1__Impl rule__MseStatement__Group__2 ;
    public final void rule__MseStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1826:1: ( rule__MseStatement__Group__1__Impl rule__MseStatement__Group__2 )
            // InternalTestScenarioLang.g:1827:2: rule__MseStatement__Group__1__Impl rule__MseStatement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MseStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MseStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group__1"


    // $ANTLR start "rule__MseStatement__Group__1__Impl"
    // InternalTestScenarioLang.g:1834:1: rule__MseStatement__Group__1__Impl : ( () ) ;
    public final void rule__MseStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1838:1: ( ( () ) )
            // InternalTestScenarioLang.g:1839:1: ( () )
            {
            // InternalTestScenarioLang.g:1839:1: ( () )
            // InternalTestScenarioLang.g:1840:1: ()
            {
             before(grammarAccess.getMseStatementAccess().getMseStatementAction_1()); 
            // InternalTestScenarioLang.g:1841:1: ()
            // InternalTestScenarioLang.g:1843:1: 
            {
            }

             after(grammarAccess.getMseStatementAccess().getMseStatementAction_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group__1__Impl"


    // $ANTLR start "rule__MseStatement__Group__2"
    // InternalTestScenarioLang.g:1853:1: rule__MseStatement__Group__2 : rule__MseStatement__Group__2__Impl rule__MseStatement__Group__3 ;
    public final void rule__MseStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1857:1: ( rule__MseStatement__Group__2__Impl rule__MseStatement__Group__3 )
            // InternalTestScenarioLang.g:1858:2: rule__MseStatement__Group__2__Impl rule__MseStatement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__MseStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MseStatement__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group__2"


    // $ANTLR start "rule__MseStatement__Group__2__Impl"
    // InternalTestScenarioLang.g:1865:1: rule__MseStatement__Group__2__Impl : ( ( rule__MseStatement__ClocksAssignment_2 ) ) ;
    public final void rule__MseStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1869:1: ( ( ( rule__MseStatement__ClocksAssignment_2 ) ) )
            // InternalTestScenarioLang.g:1870:1: ( ( rule__MseStatement__ClocksAssignment_2 ) )
            {
            // InternalTestScenarioLang.g:1870:1: ( ( rule__MseStatement__ClocksAssignment_2 ) )
            // InternalTestScenarioLang.g:1871:1: ( rule__MseStatement__ClocksAssignment_2 )
            {
             before(grammarAccess.getMseStatementAccess().getClocksAssignment_2()); 
            // InternalTestScenarioLang.g:1872:1: ( rule__MseStatement__ClocksAssignment_2 )
            // InternalTestScenarioLang.g:1872:2: rule__MseStatement__ClocksAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MseStatement__ClocksAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMseStatementAccess().getClocksAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group__2__Impl"


    // $ANTLR start "rule__MseStatement__Group__3"
    // InternalTestScenarioLang.g:1882:1: rule__MseStatement__Group__3 : rule__MseStatement__Group__3__Impl rule__MseStatement__Group__4 ;
    public final void rule__MseStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1886:1: ( rule__MseStatement__Group__3__Impl rule__MseStatement__Group__4 )
            // InternalTestScenarioLang.g:1887:2: rule__MseStatement__Group__3__Impl rule__MseStatement__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__MseStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MseStatement__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group__3"


    // $ANTLR start "rule__MseStatement__Group__3__Impl"
    // InternalTestScenarioLang.g:1894:1: rule__MseStatement__Group__3__Impl : ( ( rule__MseStatement__Group_3__0 )* ) ;
    public final void rule__MseStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1898:1: ( ( ( rule__MseStatement__Group_3__0 )* ) )
            // InternalTestScenarioLang.g:1899:1: ( ( rule__MseStatement__Group_3__0 )* )
            {
            // InternalTestScenarioLang.g:1899:1: ( ( rule__MseStatement__Group_3__0 )* )
            // InternalTestScenarioLang.g:1900:1: ( rule__MseStatement__Group_3__0 )*
            {
             before(grammarAccess.getMseStatementAccess().getGroup_3()); 
            // InternalTestScenarioLang.g:1901:1: ( rule__MseStatement__Group_3__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==22) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalTestScenarioLang.g:1901:2: rule__MseStatement__Group_3__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_19);
            	    rule__MseStatement__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getMseStatementAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group__3__Impl"


    // $ANTLR start "rule__MseStatement__Group__4"
    // InternalTestScenarioLang.g:1911:1: rule__MseStatement__Group__4 : rule__MseStatement__Group__4__Impl ;
    public final void rule__MseStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1915:1: ( rule__MseStatement__Group__4__Impl )
            // InternalTestScenarioLang.g:1916:2: rule__MseStatement__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MseStatement__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group__4"


    // $ANTLR start "rule__MseStatement__Group__4__Impl"
    // InternalTestScenarioLang.g:1922:1: rule__MseStatement__Group__4__Impl : ( ( ';' )? ) ;
    public final void rule__MseStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1926:1: ( ( ( ';' )? ) )
            // InternalTestScenarioLang.g:1927:1: ( ( ';' )? )
            {
            // InternalTestScenarioLang.g:1927:1: ( ( ';' )? )
            // InternalTestScenarioLang.g:1928:1: ( ';' )?
            {
             before(grammarAccess.getMseStatementAccess().getSemicolonKeyword_4()); 
            // InternalTestScenarioLang.g:1929:1: ( ';' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTestScenarioLang.g:1930:2: ';'
                    {
                    match(input,14,FollowSets000.FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getMseStatementAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group__4__Impl"


    // $ANTLR start "rule__MseStatement__Group_3__0"
    // InternalTestScenarioLang.g:1951:1: rule__MseStatement__Group_3__0 : rule__MseStatement__Group_3__0__Impl rule__MseStatement__Group_3__1 ;
    public final void rule__MseStatement__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1955:1: ( rule__MseStatement__Group_3__0__Impl rule__MseStatement__Group_3__1 )
            // InternalTestScenarioLang.g:1956:2: rule__MseStatement__Group_3__0__Impl rule__MseStatement__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__MseStatement__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__MseStatement__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group_3__0"


    // $ANTLR start "rule__MseStatement__Group_3__0__Impl"
    // InternalTestScenarioLang.g:1963:1: rule__MseStatement__Group_3__0__Impl : ( 'and' ) ;
    public final void rule__MseStatement__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1967:1: ( ( 'and' ) )
            // InternalTestScenarioLang.g:1968:1: ( 'and' )
            {
            // InternalTestScenarioLang.g:1968:1: ( 'and' )
            // InternalTestScenarioLang.g:1969:1: 'and'
            {
             before(grammarAccess.getMseStatementAccess().getAndKeyword_3_0()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMseStatementAccess().getAndKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group_3__0__Impl"


    // $ANTLR start "rule__MseStatement__Group_3__1"
    // InternalTestScenarioLang.g:1982:1: rule__MseStatement__Group_3__1 : rule__MseStatement__Group_3__1__Impl ;
    public final void rule__MseStatement__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1986:1: ( rule__MseStatement__Group_3__1__Impl )
            // InternalTestScenarioLang.g:1987:2: rule__MseStatement__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MseStatement__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group_3__1"


    // $ANTLR start "rule__MseStatement__Group_3__1__Impl"
    // InternalTestScenarioLang.g:1993:1: rule__MseStatement__Group_3__1__Impl : ( ( rule__MseStatement__ClocksAssignment_3_1 ) ) ;
    public final void rule__MseStatement__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:1997:1: ( ( ( rule__MseStatement__ClocksAssignment_3_1 ) ) )
            // InternalTestScenarioLang.g:1998:1: ( ( rule__MseStatement__ClocksAssignment_3_1 ) )
            {
            // InternalTestScenarioLang.g:1998:1: ( ( rule__MseStatement__ClocksAssignment_3_1 ) )
            // InternalTestScenarioLang.g:1999:1: ( rule__MseStatement__ClocksAssignment_3_1 )
            {
             before(grammarAccess.getMseStatementAccess().getClocksAssignment_3_1()); 
            // InternalTestScenarioLang.g:2000:1: ( rule__MseStatement__ClocksAssignment_3_1 )
            // InternalTestScenarioLang.g:2000:2: rule__MseStatement__ClocksAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__MseStatement__ClocksAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getMseStatementAccess().getClocksAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__Group_3__1__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group__0"
    // InternalTestScenarioLang.g:2014:1: rule__RewritingRuleCallStatement__Group__0 : rule__RewritingRuleCallStatement__Group__0__Impl rule__RewritingRuleCallStatement__Group__1 ;
    public final void rule__RewritingRuleCallStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2018:1: ( rule__RewritingRuleCallStatement__Group__0__Impl rule__RewritingRuleCallStatement__Group__1 )
            // InternalTestScenarioLang.g:2019:2: rule__RewritingRuleCallStatement__Group__0__Impl rule__RewritingRuleCallStatement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__RewritingRuleCallStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group__0"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group__0__Impl"
    // InternalTestScenarioLang.g:2026:1: rule__RewritingRuleCallStatement__Group__0__Impl : ( 'execute' ) ;
    public final void rule__RewritingRuleCallStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2030:1: ( ( 'execute' ) )
            // InternalTestScenarioLang.g:2031:1: ( 'execute' )
            {
            // InternalTestScenarioLang.g:2031:1: ( 'execute' )
            // InternalTestScenarioLang.g:2032:1: 'execute'
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getExecuteKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRewritingRuleCallStatementAccess().getExecuteKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group__0__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group__1"
    // InternalTestScenarioLang.g:2045:1: rule__RewritingRuleCallStatement__Group__1 : rule__RewritingRuleCallStatement__Group__1__Impl rule__RewritingRuleCallStatement__Group__2 ;
    public final void rule__RewritingRuleCallStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2049:1: ( rule__RewritingRuleCallStatement__Group__1__Impl rule__RewritingRuleCallStatement__Group__2 )
            // InternalTestScenarioLang.g:2050:2: rule__RewritingRuleCallStatement__Group__1__Impl rule__RewritingRuleCallStatement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__RewritingRuleCallStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group__1"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group__1__Impl"
    // InternalTestScenarioLang.g:2057:1: rule__RewritingRuleCallStatement__Group__1__Impl : ( () ) ;
    public final void rule__RewritingRuleCallStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2061:1: ( ( () ) )
            // InternalTestScenarioLang.g:2062:1: ( () )
            {
            // InternalTestScenarioLang.g:2062:1: ( () )
            // InternalTestScenarioLang.g:2063:1: ()
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getRewritingRuleCallStatementAction_1()); 
            // InternalTestScenarioLang.g:2064:1: ()
            // InternalTestScenarioLang.g:2066:1: 
            {
            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getRewritingRuleCallStatementAction_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group__1__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group__2"
    // InternalTestScenarioLang.g:2076:1: rule__RewritingRuleCallStatement__Group__2 : rule__RewritingRuleCallStatement__Group__2__Impl rule__RewritingRuleCallStatement__Group__3 ;
    public final void rule__RewritingRuleCallStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2080:1: ( rule__RewritingRuleCallStatement__Group__2__Impl rule__RewritingRuleCallStatement__Group__3 )
            // InternalTestScenarioLang.g:2081:2: rule__RewritingRuleCallStatement__Group__2__Impl rule__RewritingRuleCallStatement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__RewritingRuleCallStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group__2"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group__2__Impl"
    // InternalTestScenarioLang.g:2088:1: rule__RewritingRuleCallStatement__Group__2__Impl : ( ( rule__RewritingRuleCallStatement__Group_2__0 ) ) ;
    public final void rule__RewritingRuleCallStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2092:1: ( ( ( rule__RewritingRuleCallStatement__Group_2__0 ) ) )
            // InternalTestScenarioLang.g:2093:1: ( ( rule__RewritingRuleCallStatement__Group_2__0 ) )
            {
            // InternalTestScenarioLang.g:2093:1: ( ( rule__RewritingRuleCallStatement__Group_2__0 ) )
            // InternalTestScenarioLang.g:2094:1: ( rule__RewritingRuleCallStatement__Group_2__0 )
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getGroup_2()); 
            // InternalTestScenarioLang.g:2095:1: ( rule__RewritingRuleCallStatement__Group_2__0 )
            // InternalTestScenarioLang.g:2095:2: rule__RewritingRuleCallStatement__Group_2__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group__2__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group__3"
    // InternalTestScenarioLang.g:2105:1: rule__RewritingRuleCallStatement__Group__3 : rule__RewritingRuleCallStatement__Group__3__Impl ;
    public final void rule__RewritingRuleCallStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2109:1: ( rule__RewritingRuleCallStatement__Group__3__Impl )
            // InternalTestScenarioLang.g:2110:2: rule__RewritingRuleCallStatement__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group__3"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group__3__Impl"
    // InternalTestScenarioLang.g:2116:1: rule__RewritingRuleCallStatement__Group__3__Impl : ( ( ';' )? ) ;
    public final void rule__RewritingRuleCallStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2120:1: ( ( ( ';' )? ) )
            // InternalTestScenarioLang.g:2121:1: ( ( ';' )? )
            {
            // InternalTestScenarioLang.g:2121:1: ( ( ';' )? )
            // InternalTestScenarioLang.g:2122:1: ( ';' )?
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getSemicolonKeyword_3()); 
            // InternalTestScenarioLang.g:2123:1: ( ';' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTestScenarioLang.g:2124:2: ';'
                    {
                    match(input,14,FollowSets000.FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group__3__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2__0"
    // InternalTestScenarioLang.g:2143:1: rule__RewritingRuleCallStatement__Group_2__0 : rule__RewritingRuleCallStatement__Group_2__0__Impl rule__RewritingRuleCallStatement__Group_2__1 ;
    public final void rule__RewritingRuleCallStatement__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2147:1: ( rule__RewritingRuleCallStatement__Group_2__0__Impl rule__RewritingRuleCallStatement__Group_2__1 )
            // InternalTestScenarioLang.g:2148:2: rule__RewritingRuleCallStatement__Group_2__0__Impl rule__RewritingRuleCallStatement__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__RewritingRuleCallStatement__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2__0"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2__0__Impl"
    // InternalTestScenarioLang.g:2155:1: rule__RewritingRuleCallStatement__Group_2__0__Impl : ( ( rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0 ) ) ;
    public final void rule__RewritingRuleCallStatement__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2159:1: ( ( ( rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0 ) ) )
            // InternalTestScenarioLang.g:2160:1: ( ( rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0 ) )
            {
            // InternalTestScenarioLang.g:2160:1: ( ( rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0 ) )
            // InternalTestScenarioLang.g:2161:1: ( rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0 )
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getObjectVariableAssignment_2_0()); 
            // InternalTestScenarioLang.g:2162:1: ( rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0 )
            // InternalTestScenarioLang.g:2162:2: rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getObjectVariableAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2__0__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2__1"
    // InternalTestScenarioLang.g:2172:1: rule__RewritingRuleCallStatement__Group_2__1 : rule__RewritingRuleCallStatement__Group_2__1__Impl rule__RewritingRuleCallStatement__Group_2__2 ;
    public final void rule__RewritingRuleCallStatement__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2176:1: ( rule__RewritingRuleCallStatement__Group_2__1__Impl rule__RewritingRuleCallStatement__Group_2__2 )
            // InternalTestScenarioLang.g:2177:2: rule__RewritingRuleCallStatement__Group_2__1__Impl rule__RewritingRuleCallStatement__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__RewritingRuleCallStatement__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2__1"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2__1__Impl"
    // InternalTestScenarioLang.g:2184:1: rule__RewritingRuleCallStatement__Group_2__1__Impl : ( '.' ) ;
    public final void rule__RewritingRuleCallStatement__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2188:1: ( ( '.' ) )
            // InternalTestScenarioLang.g:2189:1: ( '.' )
            {
            // InternalTestScenarioLang.g:2189:1: ( '.' )
            // InternalTestScenarioLang.g:2190:1: '.'
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getFullStopKeyword_2_1()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRewritingRuleCallStatementAccess().getFullStopKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2__1__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2__2"
    // InternalTestScenarioLang.g:2203:1: rule__RewritingRuleCallStatement__Group_2__2 : rule__RewritingRuleCallStatement__Group_2__2__Impl rule__RewritingRuleCallStatement__Group_2__3 ;
    public final void rule__RewritingRuleCallStatement__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2207:1: ( rule__RewritingRuleCallStatement__Group_2__2__Impl rule__RewritingRuleCallStatement__Group_2__3 )
            // InternalTestScenarioLang.g:2208:2: rule__RewritingRuleCallStatement__Group_2__2__Impl rule__RewritingRuleCallStatement__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__RewritingRuleCallStatement__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2__2"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2__2__Impl"
    // InternalTestScenarioLang.g:2215:1: rule__RewritingRuleCallStatement__Group_2__2__Impl : ( ( rule__RewritingRuleCallStatement__MethodAssignment_2_2 ) ) ;
    public final void rule__RewritingRuleCallStatement__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2219:1: ( ( ( rule__RewritingRuleCallStatement__MethodAssignment_2_2 ) ) )
            // InternalTestScenarioLang.g:2220:1: ( ( rule__RewritingRuleCallStatement__MethodAssignment_2_2 ) )
            {
            // InternalTestScenarioLang.g:2220:1: ( ( rule__RewritingRuleCallStatement__MethodAssignment_2_2 ) )
            // InternalTestScenarioLang.g:2221:1: ( rule__RewritingRuleCallStatement__MethodAssignment_2_2 )
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getMethodAssignment_2_2()); 
            // InternalTestScenarioLang.g:2222:1: ( rule__RewritingRuleCallStatement__MethodAssignment_2_2 )
            // InternalTestScenarioLang.g:2222:2: rule__RewritingRuleCallStatement__MethodAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__MethodAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getMethodAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2__2__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2__3"
    // InternalTestScenarioLang.g:2232:1: rule__RewritingRuleCallStatement__Group_2__3 : rule__RewritingRuleCallStatement__Group_2__3__Impl ;
    public final void rule__RewritingRuleCallStatement__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2236:1: ( rule__RewritingRuleCallStatement__Group_2__3__Impl )
            // InternalTestScenarioLang.g:2237:2: rule__RewritingRuleCallStatement__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2__3"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2__3__Impl"
    // InternalTestScenarioLang.g:2243:1: rule__RewritingRuleCallStatement__Group_2__3__Impl : ( ( rule__RewritingRuleCallStatement__Group_2_3__0 )? ) ;
    public final void rule__RewritingRuleCallStatement__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2247:1: ( ( ( rule__RewritingRuleCallStatement__Group_2_3__0 )? ) )
            // InternalTestScenarioLang.g:2248:1: ( ( rule__RewritingRuleCallStatement__Group_2_3__0 )? )
            {
            // InternalTestScenarioLang.g:2248:1: ( ( rule__RewritingRuleCallStatement__Group_2_3__0 )? )
            // InternalTestScenarioLang.g:2249:1: ( rule__RewritingRuleCallStatement__Group_2_3__0 )?
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getGroup_2_3()); 
            // InternalTestScenarioLang.g:2250:1: ( rule__RewritingRuleCallStatement__Group_2_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==24) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalTestScenarioLang.g:2250:2: rule__RewritingRuleCallStatement__Group_2_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RewritingRuleCallStatement__Group_2_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getGroup_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2__3__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3__0"
    // InternalTestScenarioLang.g:2268:1: rule__RewritingRuleCallStatement__Group_2_3__0 : rule__RewritingRuleCallStatement__Group_2_3__0__Impl rule__RewritingRuleCallStatement__Group_2_3__1 ;
    public final void rule__RewritingRuleCallStatement__Group_2_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2272:1: ( rule__RewritingRuleCallStatement__Group_2_3__0__Impl rule__RewritingRuleCallStatement__Group_2_3__1 )
            // InternalTestScenarioLang.g:2273:2: rule__RewritingRuleCallStatement__Group_2_3__0__Impl rule__RewritingRuleCallStatement__Group_2_3__1
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__RewritingRuleCallStatement__Group_2_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3__0"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3__0__Impl"
    // InternalTestScenarioLang.g:2280:1: rule__RewritingRuleCallStatement__Group_2_3__0__Impl : ( '(' ) ;
    public final void rule__RewritingRuleCallStatement__Group_2_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2284:1: ( ( '(' ) )
            // InternalTestScenarioLang.g:2285:1: ( '(' )
            {
            // InternalTestScenarioLang.g:2285:1: ( '(' )
            // InternalTestScenarioLang.g:2286:1: '('
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getLeftParenthesisKeyword_2_3_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRewritingRuleCallStatementAccess().getLeftParenthesisKeyword_2_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3__0__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3__1"
    // InternalTestScenarioLang.g:2299:1: rule__RewritingRuleCallStatement__Group_2_3__1 : rule__RewritingRuleCallStatement__Group_2_3__1__Impl rule__RewritingRuleCallStatement__Group_2_3__2 ;
    public final void rule__RewritingRuleCallStatement__Group_2_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2303:1: ( rule__RewritingRuleCallStatement__Group_2_3__1__Impl rule__RewritingRuleCallStatement__Group_2_3__2 )
            // InternalTestScenarioLang.g:2304:2: rule__RewritingRuleCallStatement__Group_2_3__1__Impl rule__RewritingRuleCallStatement__Group_2_3__2
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__RewritingRuleCallStatement__Group_2_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3__1"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3__1__Impl"
    // InternalTestScenarioLang.g:2311:1: rule__RewritingRuleCallStatement__Group_2_3__1__Impl : ( ( rule__RewritingRuleCallStatement__Group_2_3_1__0 )* ) ;
    public final void rule__RewritingRuleCallStatement__Group_2_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2315:1: ( ( ( rule__RewritingRuleCallStatement__Group_2_3_1__0 )* ) )
            // InternalTestScenarioLang.g:2316:1: ( ( rule__RewritingRuleCallStatement__Group_2_3_1__0 )* )
            {
            // InternalTestScenarioLang.g:2316:1: ( ( rule__RewritingRuleCallStatement__Group_2_3_1__0 )* )
            // InternalTestScenarioLang.g:2317:1: ( rule__RewritingRuleCallStatement__Group_2_3_1__0 )*
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getGroup_2_3_1()); 
            // InternalTestScenarioLang.g:2318:1: ( rule__RewritingRuleCallStatement__Group_2_3_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_INT)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalTestScenarioLang.g:2318:2: rule__RewritingRuleCallStatement__Group_2_3_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_22);
            	    rule__RewritingRuleCallStatement__Group_2_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getRewritingRuleCallStatementAccess().getGroup_2_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3__1__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3__2"
    // InternalTestScenarioLang.g:2328:1: rule__RewritingRuleCallStatement__Group_2_3__2 : rule__RewritingRuleCallStatement__Group_2_3__2__Impl ;
    public final void rule__RewritingRuleCallStatement__Group_2_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2332:1: ( rule__RewritingRuleCallStatement__Group_2_3__2__Impl )
            // InternalTestScenarioLang.g:2333:2: rule__RewritingRuleCallStatement__Group_2_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3__2"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3__2__Impl"
    // InternalTestScenarioLang.g:2339:1: rule__RewritingRuleCallStatement__Group_2_3__2__Impl : ( ')' ) ;
    public final void rule__RewritingRuleCallStatement__Group_2_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2343:1: ( ( ')' ) )
            // InternalTestScenarioLang.g:2344:1: ( ')' )
            {
            // InternalTestScenarioLang.g:2344:1: ( ')' )
            // InternalTestScenarioLang.g:2345:1: ')'
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getRightParenthesisKeyword_2_3_2()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRewritingRuleCallStatementAccess().getRightParenthesisKeyword_2_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3__2__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3_1__0"
    // InternalTestScenarioLang.g:2364:1: rule__RewritingRuleCallStatement__Group_2_3_1__0 : rule__RewritingRuleCallStatement__Group_2_3_1__0__Impl rule__RewritingRuleCallStatement__Group_2_3_1__1 ;
    public final void rule__RewritingRuleCallStatement__Group_2_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2368:1: ( rule__RewritingRuleCallStatement__Group_2_3_1__0__Impl rule__RewritingRuleCallStatement__Group_2_3_1__1 )
            // InternalTestScenarioLang.g:2369:2: rule__RewritingRuleCallStatement__Group_2_3_1__0__Impl rule__RewritingRuleCallStatement__Group_2_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__RewritingRuleCallStatement__Group_2_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3_1__0"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3_1__0__Impl"
    // InternalTestScenarioLang.g:2376:1: rule__RewritingRuleCallStatement__Group_2_3_1__0__Impl : ( ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0 ) ) ;
    public final void rule__RewritingRuleCallStatement__Group_2_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2380:1: ( ( ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0 ) ) )
            // InternalTestScenarioLang.g:2381:1: ( ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0 ) )
            {
            // InternalTestScenarioLang.g:2381:1: ( ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0 ) )
            // InternalTestScenarioLang.g:2382:1: ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0 )
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getParametersAssignment_2_3_1_0()); 
            // InternalTestScenarioLang.g:2383:1: ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0 )
            // InternalTestScenarioLang.g:2383:2: rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getParametersAssignment_2_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3_1__0__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3_1__1"
    // InternalTestScenarioLang.g:2393:1: rule__RewritingRuleCallStatement__Group_2_3_1__1 : rule__RewritingRuleCallStatement__Group_2_3_1__1__Impl ;
    public final void rule__RewritingRuleCallStatement__Group_2_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2397:1: ( rule__RewritingRuleCallStatement__Group_2_3_1__1__Impl )
            // InternalTestScenarioLang.g:2398:2: rule__RewritingRuleCallStatement__Group_2_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3_1__1"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3_1__1__Impl"
    // InternalTestScenarioLang.g:2404:1: rule__RewritingRuleCallStatement__Group_2_3_1__1__Impl : ( ( rule__RewritingRuleCallStatement__Group_2_3_1_1__0 )* ) ;
    public final void rule__RewritingRuleCallStatement__Group_2_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2408:1: ( ( ( rule__RewritingRuleCallStatement__Group_2_3_1_1__0 )* ) )
            // InternalTestScenarioLang.g:2409:1: ( ( rule__RewritingRuleCallStatement__Group_2_3_1_1__0 )* )
            {
            // InternalTestScenarioLang.g:2409:1: ( ( rule__RewritingRuleCallStatement__Group_2_3_1_1__0 )* )
            // InternalTestScenarioLang.g:2410:1: ( rule__RewritingRuleCallStatement__Group_2_3_1_1__0 )*
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getGroup_2_3_1_1()); 
            // InternalTestScenarioLang.g:2411:1: ( rule__RewritingRuleCallStatement__Group_2_3_1_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==26) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalTestScenarioLang.g:2411:2: rule__RewritingRuleCallStatement__Group_2_3_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    rule__RewritingRuleCallStatement__Group_2_3_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getRewritingRuleCallStatementAccess().getGroup_2_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3_1__1__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3_1_1__0"
    // InternalTestScenarioLang.g:2425:1: rule__RewritingRuleCallStatement__Group_2_3_1_1__0 : rule__RewritingRuleCallStatement__Group_2_3_1_1__0__Impl rule__RewritingRuleCallStatement__Group_2_3_1_1__1 ;
    public final void rule__RewritingRuleCallStatement__Group_2_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2429:1: ( rule__RewritingRuleCallStatement__Group_2_3_1_1__0__Impl rule__RewritingRuleCallStatement__Group_2_3_1_1__1 )
            // InternalTestScenarioLang.g:2430:2: rule__RewritingRuleCallStatement__Group_2_3_1_1__0__Impl rule__RewritingRuleCallStatement__Group_2_3_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__RewritingRuleCallStatement__Group_2_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2_3_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3_1_1__0"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3_1_1__0__Impl"
    // InternalTestScenarioLang.g:2437:1: rule__RewritingRuleCallStatement__Group_2_3_1_1__0__Impl : ( ',' ) ;
    public final void rule__RewritingRuleCallStatement__Group_2_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2441:1: ( ( ',' ) )
            // InternalTestScenarioLang.g:2442:1: ( ',' )
            {
            // InternalTestScenarioLang.g:2442:1: ( ',' )
            // InternalTestScenarioLang.g:2443:1: ','
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getCommaKeyword_2_3_1_1_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRewritingRuleCallStatementAccess().getCommaKeyword_2_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3_1_1__0__Impl"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3_1_1__1"
    // InternalTestScenarioLang.g:2456:1: rule__RewritingRuleCallStatement__Group_2_3_1_1__1 : rule__RewritingRuleCallStatement__Group_2_3_1_1__1__Impl ;
    public final void rule__RewritingRuleCallStatement__Group_2_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2460:1: ( rule__RewritingRuleCallStatement__Group_2_3_1_1__1__Impl )
            // InternalTestScenarioLang.g:2461:2: rule__RewritingRuleCallStatement__Group_2_3_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__Group_2_3_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3_1_1__1"


    // $ANTLR start "rule__RewritingRuleCallStatement__Group_2_3_1_1__1__Impl"
    // InternalTestScenarioLang.g:2467:1: rule__RewritingRuleCallStatement__Group_2_3_1_1__1__Impl : ( ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1 ) ) ;
    public final void rule__RewritingRuleCallStatement__Group_2_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2471:1: ( ( ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1 ) ) )
            // InternalTestScenarioLang.g:2472:1: ( ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1 ) )
            {
            // InternalTestScenarioLang.g:2472:1: ( ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1 ) )
            // InternalTestScenarioLang.g:2473:1: ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1 )
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getParametersAssignment_2_3_1_1_1()); 
            // InternalTestScenarioLang.g:2474:1: ( rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1 )
            // InternalTestScenarioLang.g:2474:2: rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getParametersAssignment_2_3_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__Group_2_3_1_1__1__Impl"


    // $ANTLR start "rule__Scenario__NameAssignment_2"
    // InternalTestScenarioLang.g:2489:1: rule__Scenario__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Scenario__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2493:1: ( ( ruleEString ) )
            // InternalTestScenarioLang.g:2494:1: ( ruleEString )
            {
            // InternalTestScenarioLang.g:2494:1: ( ruleEString )
            // InternalTestScenarioLang.g:2495:1: ruleEString
            {
             before(grammarAccess.getScenarioAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__NameAssignment_2"


    // $ANTLR start "rule__Scenario__ModelImportsAssignment_3_0_0"
    // InternalTestScenarioLang.g:2504:1: rule__Scenario__ModelImportsAssignment_3_0_0 : ( ruleImportStatement ) ;
    public final void rule__Scenario__ModelImportsAssignment_3_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2508:1: ( ( ruleImportStatement ) )
            // InternalTestScenarioLang.g:2509:1: ( ruleImportStatement )
            {
            // InternalTestScenarioLang.g:2509:1: ( ruleImportStatement )
            // InternalTestScenarioLang.g:2510:1: ruleImportStatement
            {
             before(grammarAccess.getScenarioAccess().getModelImportsImportStatementParserRuleCall_3_0_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleImportStatement();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getModelImportsImportStatementParserRuleCall_3_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__ModelImportsAssignment_3_0_0"


    // $ANTLR start "rule__Scenario__ClassImportsAssignment_3_0_1"
    // InternalTestScenarioLang.g:2519:1: rule__Scenario__ClassImportsAssignment_3_0_1 : ( ruleImportJavaStatement ) ;
    public final void rule__Scenario__ClassImportsAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2523:1: ( ( ruleImportJavaStatement ) )
            // InternalTestScenarioLang.g:2524:1: ( ruleImportJavaStatement )
            {
            // InternalTestScenarioLang.g:2524:1: ( ruleImportJavaStatement )
            // InternalTestScenarioLang.g:2525:1: ruleImportJavaStatement
            {
             before(grammarAccess.getScenarioAccess().getClassImportsImportJavaStatementParserRuleCall_3_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleImportJavaStatement();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getClassImportsImportJavaStatementParserRuleCall_3_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__ClassImportsAssignment_3_0_1"


    // $ANTLR start "rule__Scenario__ModelImportsAssignment_3_1_0"
    // InternalTestScenarioLang.g:2534:1: rule__Scenario__ModelImportsAssignment_3_1_0 : ( ruleImportStatement ) ;
    public final void rule__Scenario__ModelImportsAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2538:1: ( ( ruleImportStatement ) )
            // InternalTestScenarioLang.g:2539:1: ( ruleImportStatement )
            {
            // InternalTestScenarioLang.g:2539:1: ( ruleImportStatement )
            // InternalTestScenarioLang.g:2540:1: ruleImportStatement
            {
             before(grammarAccess.getScenarioAccess().getModelImportsImportStatementParserRuleCall_3_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleImportStatement();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getModelImportsImportStatementParserRuleCall_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__ModelImportsAssignment_3_1_0"


    // $ANTLR start "rule__Scenario__ClassImportsAssignment_3_1_1"
    // InternalTestScenarioLang.g:2549:1: rule__Scenario__ClassImportsAssignment_3_1_1 : ( ruleImportJavaStatement ) ;
    public final void rule__Scenario__ClassImportsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2553:1: ( ( ruleImportJavaStatement ) )
            // InternalTestScenarioLang.g:2554:1: ( ruleImportJavaStatement )
            {
            // InternalTestScenarioLang.g:2554:1: ( ruleImportJavaStatement )
            // InternalTestScenarioLang.g:2555:1: ruleImportJavaStatement
            {
             before(grammarAccess.getScenarioAccess().getClassImportsImportJavaStatementParserRuleCall_3_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleImportJavaStatement();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getClassImportsImportJavaStatementParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__ClassImportsAssignment_3_1_1"


    // $ANTLR start "rule__Scenario__VariablesAssignment_4_0"
    // InternalTestScenarioLang.g:2564:1: rule__Scenario__VariablesAssignment_4_0 : ( ruleObjectVariable ) ;
    public final void rule__Scenario__VariablesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2568:1: ( ( ruleObjectVariable ) )
            // InternalTestScenarioLang.g:2569:1: ( ruleObjectVariable )
            {
            // InternalTestScenarioLang.g:2569:1: ( ruleObjectVariable )
            // InternalTestScenarioLang.g:2570:1: ruleObjectVariable
            {
             before(grammarAccess.getScenarioAccess().getVariablesObjectVariableParserRuleCall_4_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleObjectVariable();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getVariablesObjectVariableParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__VariablesAssignment_4_0"


    // $ANTLR start "rule__Scenario__VariablesAssignment_4_1"
    // InternalTestScenarioLang.g:2579:1: rule__Scenario__VariablesAssignment_4_1 : ( ruleObjectVariable ) ;
    public final void rule__Scenario__VariablesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2583:1: ( ( ruleObjectVariable ) )
            // InternalTestScenarioLang.g:2584:1: ( ruleObjectVariable )
            {
            // InternalTestScenarioLang.g:2584:1: ( ruleObjectVariable )
            // InternalTestScenarioLang.g:2585:1: ruleObjectVariable
            {
             before(grammarAccess.getScenarioAccess().getVariablesObjectVariableParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleObjectVariable();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getVariablesObjectVariableParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__VariablesAssignment_4_1"


    // $ANTLR start "rule__Scenario__StatementSequenceAssignment_5"
    // InternalTestScenarioLang.g:2594:1: rule__Scenario__StatementSequenceAssignment_5 : ( ruleStatement ) ;
    public final void rule__Scenario__StatementSequenceAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2598:1: ( ( ruleStatement ) )
            // InternalTestScenarioLang.g:2599:1: ( ruleStatement )
            {
            // InternalTestScenarioLang.g:2599:1: ( ruleStatement )
            // InternalTestScenarioLang.g:2600:1: ruleStatement
            {
             before(grammarAccess.getScenarioAccess().getStatementSequenceStatementParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getStatementSequenceStatementParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__StatementSequenceAssignment_5"


    // $ANTLR start "rule__ImportStatement__ImportURIAssignment_1"
    // InternalTestScenarioLang.g:2609:1: rule__ImportStatement__ImportURIAssignment_1 : ( ruleEString ) ;
    public final void rule__ImportStatement__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2613:1: ( ( ruleEString ) )
            // InternalTestScenarioLang.g:2614:1: ( ruleEString )
            {
            // InternalTestScenarioLang.g:2614:1: ( ruleEString )
            // InternalTestScenarioLang.g:2615:1: ruleEString
            {
             before(grammarAccess.getImportStatementAccess().getImportURIEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImportStatementAccess().getImportURIEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__ImportURIAssignment_1"


    // $ANTLR start "rule__ImportStatement__AliasAssignment_2_0"
    // InternalTestScenarioLang.g:2624:1: rule__ImportStatement__AliasAssignment_2_0 : ( ( ';' ) ) ;
    public final void rule__ImportStatement__AliasAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2628:1: ( ( ( ';' ) ) )
            // InternalTestScenarioLang.g:2629:1: ( ( ';' ) )
            {
            // InternalTestScenarioLang.g:2629:1: ( ( ';' ) )
            // InternalTestScenarioLang.g:2630:1: ( ';' )
            {
             before(grammarAccess.getImportStatementAccess().getAliasSemicolonKeyword_2_0_0()); 
            // InternalTestScenarioLang.g:2631:1: ( ';' )
            // InternalTestScenarioLang.g:2632:1: ';'
            {
             before(grammarAccess.getImportStatementAccess().getAliasSemicolonKeyword_2_0_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getImportStatementAccess().getAliasSemicolonKeyword_2_0_0()); 

            }

             after(grammarAccess.getImportStatementAccess().getAliasSemicolonKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__AliasAssignment_2_0"


    // $ANTLR start "rule__ImportStatement__AliasAssignment_2_1_1"
    // InternalTestScenarioLang.g:2647:1: rule__ImportStatement__AliasAssignment_2_1_1 : ( ruleEString ) ;
    public final void rule__ImportStatement__AliasAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2651:1: ( ( ruleEString ) )
            // InternalTestScenarioLang.g:2652:1: ( ruleEString )
            {
            // InternalTestScenarioLang.g:2652:1: ( ruleEString )
            // InternalTestScenarioLang.g:2653:1: ruleEString
            {
             before(grammarAccess.getImportStatementAccess().getAliasEStringParserRuleCall_2_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImportStatementAccess().getAliasEStringParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportStatement__AliasAssignment_2_1_1"


    // $ANTLR start "rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1"
    // InternalTestScenarioLang.g:2662:1: rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1 : ( ruleQualifiedName ) ;
    public final void rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2666:1: ( ( ruleQualifiedName ) )
            // InternalTestScenarioLang.g:2667:1: ( ruleQualifiedName )
            {
            // InternalTestScenarioLang.g:2667:1: ( ruleQualifiedName )
            // InternalTestScenarioLang.g:2668:1: ruleQualifiedName
            {
             before(grammarAccess.getImportJavaStatementAccess().getImportedNamespaceQualifiedNameParserRuleCall_0_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getImportJavaStatementAccess().getImportedNamespaceQualifiedNameParserRuleCall_0_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__ImportedNamespaceAssignment_0_0_1"


    // $ANTLR start "rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1"
    // InternalTestScenarioLang.g:2677:1: rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1 : ( ruleQualifiedNameWithWildCard ) ;
    public final void rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2681:1: ( ( ruleQualifiedNameWithWildCard ) )
            // InternalTestScenarioLang.g:2682:1: ( ruleQualifiedNameWithWildCard )
            {
            // InternalTestScenarioLang.g:2682:1: ( ruleQualifiedNameWithWildCard )
            // InternalTestScenarioLang.g:2683:1: ruleQualifiedNameWithWildCard
            {
             before(grammarAccess.getImportJavaStatementAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_0_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQualifiedNameWithWildCard();

            state._fsp--;

             after(grammarAccess.getImportJavaStatementAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportJavaStatement__ImportedNamespaceAssignment_0_1_1"


    // $ANTLR start "rule__ObjectVariable__NameAssignment_1"
    // InternalTestScenarioLang.g:2692:1: rule__ObjectVariable__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__ObjectVariable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2696:1: ( ( ruleEString ) )
            // InternalTestScenarioLang.g:2697:1: ( ruleEString )
            {
            // InternalTestScenarioLang.g:2697:1: ( ruleEString )
            // InternalTestScenarioLang.g:2698:1: ruleEString
            {
             before(grammarAccess.getObjectVariableAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getObjectVariableAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__NameAssignment_1"


    // $ANTLR start "rule__ObjectVariable__TypeAssignment_3"
    // InternalTestScenarioLang.g:2707:1: rule__ObjectVariable__TypeAssignment_3 : ( ruleJvmTypeReference ) ;
    public final void rule__ObjectVariable__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2711:1: ( ( ruleJvmTypeReference ) )
            // InternalTestScenarioLang.g:2712:1: ( ruleJvmTypeReference )
            {
            // InternalTestScenarioLang.g:2712:1: ( ruleJvmTypeReference )
            // InternalTestScenarioLang.g:2713:1: ruleJvmTypeReference
            {
             before(grammarAccess.getObjectVariableAccess().getTypeJvmTypeReferenceParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleJvmTypeReference();

            state._fsp--;

             after(grammarAccess.getObjectVariableAccess().getTypeJvmTypeReferenceParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariable__TypeAssignment_3"


    // $ANTLR start "rule__JvmTypeReference__TypeAssignment_1"
    // InternalTestScenarioLang.g:2722:1: rule__JvmTypeReference__TypeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__JvmTypeReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2726:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTestScenarioLang.g:2727:1: ( ( ruleQualifiedName ) )
            {
            // InternalTestScenarioLang.g:2727:1: ( ( ruleQualifiedName ) )
            // InternalTestScenarioLang.g:2728:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getJvmTypeReferenceAccess().getTypeJvmTypeCrossReference_1_0()); 
            // InternalTestScenarioLang.g:2729:1: ( ruleQualifiedName )
            // InternalTestScenarioLang.g:2730:1: ruleQualifiedName
            {
             before(grammarAccess.getJvmTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getJvmTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getJvmTypeReferenceAccess().getTypeJvmTypeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__TypeAssignment_1"


    // $ANTLR start "rule__MseStatement__ClocksAssignment_2"
    // InternalTestScenarioLang.g:2741:1: rule__MseStatement__ClocksAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__MseStatement__ClocksAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2745:1: ( ( ( RULE_ID ) ) )
            // InternalTestScenarioLang.g:2746:1: ( ( RULE_ID ) )
            {
            // InternalTestScenarioLang.g:2746:1: ( ( RULE_ID ) )
            // InternalTestScenarioLang.g:2747:1: ( RULE_ID )
            {
             before(grammarAccess.getMseStatementAccess().getClocksClockCrossReference_2_0()); 
            // InternalTestScenarioLang.g:2748:1: ( RULE_ID )
            // InternalTestScenarioLang.g:2749:1: RULE_ID
            {
             before(grammarAccess.getMseStatementAccess().getClocksClockIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMseStatementAccess().getClocksClockIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getMseStatementAccess().getClocksClockCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__ClocksAssignment_2"


    // $ANTLR start "rule__MseStatement__ClocksAssignment_3_1"
    // InternalTestScenarioLang.g:2760:1: rule__MseStatement__ClocksAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__MseStatement__ClocksAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2764:1: ( ( ( RULE_ID ) ) )
            // InternalTestScenarioLang.g:2765:1: ( ( RULE_ID ) )
            {
            // InternalTestScenarioLang.g:2765:1: ( ( RULE_ID ) )
            // InternalTestScenarioLang.g:2766:1: ( RULE_ID )
            {
             before(grammarAccess.getMseStatementAccess().getClocksClockCrossReference_3_1_0()); 
            // InternalTestScenarioLang.g:2767:1: ( RULE_ID )
            // InternalTestScenarioLang.g:2768:1: RULE_ID
            {
             before(grammarAccess.getMseStatementAccess().getClocksClockIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getMseStatementAccess().getClocksClockIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getMseStatementAccess().getClocksClockCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MseStatement__ClocksAssignment_3_1"


    // $ANTLR start "rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0"
    // InternalTestScenarioLang.g:2779:1: rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2783:1: ( ( ( RULE_ID ) ) )
            // InternalTestScenarioLang.g:2784:1: ( ( RULE_ID ) )
            {
            // InternalTestScenarioLang.g:2784:1: ( ( RULE_ID ) )
            // InternalTestScenarioLang.g:2785:1: ( RULE_ID )
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getObjectVariableObjectVariableCrossReference_2_0_0()); 
            // InternalTestScenarioLang.g:2786:1: ( RULE_ID )
            // InternalTestScenarioLang.g:2787:1: RULE_ID
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getObjectVariableObjectVariableIDTerminalRuleCall_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRewritingRuleCallStatementAccess().getObjectVariableObjectVariableIDTerminalRuleCall_2_0_0_1()); 

            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getObjectVariableObjectVariableCrossReference_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__ObjectVariableAssignment_2_0"


    // $ANTLR start "rule__RewritingRuleCallStatement__MethodAssignment_2_2"
    // InternalTestScenarioLang.g:2798:1: rule__RewritingRuleCallStatement__MethodAssignment_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__RewritingRuleCallStatement__MethodAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2802:1: ( ( ( RULE_ID ) ) )
            // InternalTestScenarioLang.g:2803:1: ( ( RULE_ID ) )
            {
            // InternalTestScenarioLang.g:2803:1: ( ( RULE_ID ) )
            // InternalTestScenarioLang.g:2804:1: ( RULE_ID )
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getMethodJvmOperationCrossReference_2_2_0()); 
            // InternalTestScenarioLang.g:2805:1: ( RULE_ID )
            // InternalTestScenarioLang.g:2806:1: RULE_ID
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getMethodJvmOperationIDTerminalRuleCall_2_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRewritingRuleCallStatementAccess().getMethodJvmOperationIDTerminalRuleCall_2_2_0_1()); 

            }

             after(grammarAccess.getRewritingRuleCallStatementAccess().getMethodJvmOperationCrossReference_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__MethodAssignment_2_2"


    // $ANTLR start "rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0"
    // InternalTestScenarioLang.g:2817:1: rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0 : ( ruleVariable ) ;
    public final void rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2821:1: ( ( ruleVariable ) )
            // InternalTestScenarioLang.g:2822:1: ( ruleVariable )
            {
            // InternalTestScenarioLang.g:2822:1: ( ruleVariable )
            // InternalTestScenarioLang.g:2823:1: ruleVariable
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getParametersVariableParserRuleCall_2_3_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getRewritingRuleCallStatementAccess().getParametersVariableParserRuleCall_2_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_0"


    // $ANTLR start "rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1"
    // InternalTestScenarioLang.g:2832:1: rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1 : ( ruleVariable ) ;
    public final void rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2836:1: ( ( ruleVariable ) )
            // InternalTestScenarioLang.g:2837:1: ( ruleVariable )
            {
            // InternalTestScenarioLang.g:2837:1: ( ruleVariable )
            // InternalTestScenarioLang.g:2838:1: ruleVariable
            {
             before(grammarAccess.getRewritingRuleCallStatementAccess().getParametersVariableParserRuleCall_2_3_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getRewritingRuleCallStatementAccess().getParametersVariableParserRuleCall_2_3_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RewritingRuleCallStatement__ParametersAssignment_2_3_1_1_1"


    // $ANTLR start "rule__EObjectRef__ObjectAssignment"
    // InternalTestScenarioLang.g:2847:1: rule__EObjectRef__ObjectAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__EObjectRef__ObjectAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2851:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTestScenarioLang.g:2852:1: ( ( ruleQualifiedName ) )
            {
            // InternalTestScenarioLang.g:2852:1: ( ( ruleQualifiedName ) )
            // InternalTestScenarioLang.g:2853:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getEObjectRefAccess().getObjectEObjectCrossReference_0()); 
            // InternalTestScenarioLang.g:2854:1: ( ruleQualifiedName )
            // InternalTestScenarioLang.g:2855:1: ruleQualifiedName
            {
             before(grammarAccess.getEObjectRefAccess().getObjectEObjectQualifiedNameParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getEObjectRefAccess().getObjectEObjectQualifiedNameParserRuleCall_0_1()); 

            }

             after(grammarAccess.getEObjectRefAccess().getObjectEObjectCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EObjectRef__ObjectAssignment"


    // $ANTLR start "rule__StringLiteral__ValueAssignment"
    // InternalTestScenarioLang.g:2866:1: rule__StringLiteral__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2870:1: ( ( RULE_STRING ) )
            // InternalTestScenarioLang.g:2871:1: ( RULE_STRING )
            {
            // InternalTestScenarioLang.g:2871:1: ( RULE_STRING )
            // InternalTestScenarioLang.g:2872:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteral__ValueAssignment"


    // $ANTLR start "rule__IntegerLiteral__ValueAssignment"
    // InternalTestScenarioLang.g:2881:1: rule__IntegerLiteral__ValueAssignment : ( RULE_INT ) ;
    public final void rule__IntegerLiteral__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTestScenarioLang.g:2885:1: ( ( RULE_INT ) )
            // InternalTestScenarioLang.g:2886:1: ( RULE_INT )
            {
            // InternalTestScenarioLang.g:2886:1: ( RULE_INT )
            // InternalTestScenarioLang.g:2887:1: RULE_INT
            {
             before(grammarAccess.getIntegerLiteralAccess().getValueINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getIntegerLiteralAccess().getValueINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerLiteral__ValueAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000A39030L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000A39032L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000019000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000019002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000404000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000070L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000072L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000070L});
    }


}