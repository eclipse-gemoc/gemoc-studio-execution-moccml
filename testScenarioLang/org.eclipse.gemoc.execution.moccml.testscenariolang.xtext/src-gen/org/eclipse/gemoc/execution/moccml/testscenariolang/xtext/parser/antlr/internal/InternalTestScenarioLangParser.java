package org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.services.TestScenarioLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTestScenarioLangParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Scenario'", "'importModel'", "';'", "'as'", "'importClass'", "'importPackage'", "'Variable'", "':'", "'.'", "'*'", "'expect'", "'and'", "'execute'", "'('", "','", "')'"
    };
    public static final int RULE_STRING=5;
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
    public static final int RULE_ID=4;
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
     	
        public InternalTestScenarioLangParser(TokenStream input, TestScenarioLangGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Scenario";	
       	}
       	
       	@Override
       	protected TestScenarioLangGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleScenario"
    // InternalTestScenarioLang.g:67:1: entryRuleScenario returns [EObject current=null] : iv_ruleScenario= ruleScenario EOF ;
    public final EObject entryRuleScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario = null;


        try {
            // InternalTestScenarioLang.g:68:2: (iv_ruleScenario= ruleScenario EOF )
            // InternalTestScenarioLang.g:69:2: iv_ruleScenario= ruleScenario EOF
            {
             newCompositeNode(grammarAccess.getScenarioRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleScenario=ruleScenario();

            state._fsp--;

             current =iv_ruleScenario; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario"


    // $ANTLR start "ruleScenario"
    // InternalTestScenarioLang.g:76:1: ruleScenario returns [EObject current=null] : ( () otherlv_1= 'Scenario' ( (lv_name_2_0= ruleEString ) )? ( ( ( (lv_modelImports_3_0= ruleImportStatement ) ) | ( (lv_classImports_4_0= ruleImportJavaStatement ) ) ) ( ( (lv_modelImports_5_0= ruleImportStatement ) ) | ( (lv_classImports_6_0= ruleImportJavaStatement ) ) )* )? ( ( (lv_variables_7_0= ruleObjectVariable ) ) ( (lv_variables_8_0= ruleObjectVariable ) )* )? ( (lv_statementSequence_9_0= ruleStatement ) )+ ) ;
    public final EObject ruleScenario() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_modelImports_3_0 = null;

        EObject lv_classImports_4_0 = null;

        EObject lv_modelImports_5_0 = null;

        EObject lv_classImports_6_0 = null;

        EObject lv_variables_7_0 = null;

        EObject lv_variables_8_0 = null;

        EObject lv_statementSequence_9_0 = null;


         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:79:28: ( ( () otherlv_1= 'Scenario' ( (lv_name_2_0= ruleEString ) )? ( ( ( (lv_modelImports_3_0= ruleImportStatement ) ) | ( (lv_classImports_4_0= ruleImportJavaStatement ) ) ) ( ( (lv_modelImports_5_0= ruleImportStatement ) ) | ( (lv_classImports_6_0= ruleImportJavaStatement ) ) )* )? ( ( (lv_variables_7_0= ruleObjectVariable ) ) ( (lv_variables_8_0= ruleObjectVariable ) )* )? ( (lv_statementSequence_9_0= ruleStatement ) )+ ) )
            // InternalTestScenarioLang.g:80:1: ( () otherlv_1= 'Scenario' ( (lv_name_2_0= ruleEString ) )? ( ( ( (lv_modelImports_3_0= ruleImportStatement ) ) | ( (lv_classImports_4_0= ruleImportJavaStatement ) ) ) ( ( (lv_modelImports_5_0= ruleImportStatement ) ) | ( (lv_classImports_6_0= ruleImportJavaStatement ) ) )* )? ( ( (lv_variables_7_0= ruleObjectVariable ) ) ( (lv_variables_8_0= ruleObjectVariable ) )* )? ( (lv_statementSequence_9_0= ruleStatement ) )+ )
            {
            // InternalTestScenarioLang.g:80:1: ( () otherlv_1= 'Scenario' ( (lv_name_2_0= ruleEString ) )? ( ( ( (lv_modelImports_3_0= ruleImportStatement ) ) | ( (lv_classImports_4_0= ruleImportJavaStatement ) ) ) ( ( (lv_modelImports_5_0= ruleImportStatement ) ) | ( (lv_classImports_6_0= ruleImportJavaStatement ) ) )* )? ( ( (lv_variables_7_0= ruleObjectVariable ) ) ( (lv_variables_8_0= ruleObjectVariable ) )* )? ( (lv_statementSequence_9_0= ruleStatement ) )+ )
            // InternalTestScenarioLang.g:80:2: () otherlv_1= 'Scenario' ( (lv_name_2_0= ruleEString ) )? ( ( ( (lv_modelImports_3_0= ruleImportStatement ) ) | ( (lv_classImports_4_0= ruleImportJavaStatement ) ) ) ( ( (lv_modelImports_5_0= ruleImportStatement ) ) | ( (lv_classImports_6_0= ruleImportJavaStatement ) ) )* )? ( ( (lv_variables_7_0= ruleObjectVariable ) ) ( (lv_variables_8_0= ruleObjectVariable ) )* )? ( (lv_statementSequence_9_0= ruleStatement ) )+
            {
            // InternalTestScenarioLang.g:80:2: ()
            // InternalTestScenarioLang.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getScenarioAccess().getScenarioAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getScenarioAccess().getScenarioKeyword_1());
                
            // InternalTestScenarioLang.g:90:1: ( (lv_name_2_0= ruleEString ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalTestScenarioLang.g:91:1: (lv_name_2_0= ruleEString )
                    {
                    // InternalTestScenarioLang.g:91:1: (lv_name_2_0= ruleEString )
                    // InternalTestScenarioLang.g:92:3: lv_name_2_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenarioAccess().getNameEStringParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_name_2_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenarioRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalTestScenarioLang.g:108:3: ( ( ( (lv_modelImports_3_0= ruleImportStatement ) ) | ( (lv_classImports_4_0= ruleImportJavaStatement ) ) ) ( ( (lv_modelImports_5_0= ruleImportStatement ) ) | ( (lv_classImports_6_0= ruleImportJavaStatement ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12||(LA4_0>=15 && LA4_0<=16)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalTestScenarioLang.g:108:4: ( ( (lv_modelImports_3_0= ruleImportStatement ) ) | ( (lv_classImports_4_0= ruleImportJavaStatement ) ) ) ( ( (lv_modelImports_5_0= ruleImportStatement ) ) | ( (lv_classImports_6_0= ruleImportJavaStatement ) ) )*
                    {
                    // InternalTestScenarioLang.g:108:4: ( ( (lv_modelImports_3_0= ruleImportStatement ) ) | ( (lv_classImports_4_0= ruleImportJavaStatement ) ) )
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
                            // InternalTestScenarioLang.g:108:5: ( (lv_modelImports_3_0= ruleImportStatement ) )
                            {
                            // InternalTestScenarioLang.g:108:5: ( (lv_modelImports_3_0= ruleImportStatement ) )
                            // InternalTestScenarioLang.g:109:1: (lv_modelImports_3_0= ruleImportStatement )
                            {
                            // InternalTestScenarioLang.g:109:1: (lv_modelImports_3_0= ruleImportStatement )
                            // InternalTestScenarioLang.g:110:3: lv_modelImports_3_0= ruleImportStatement
                            {
                             
                            	        newCompositeNode(grammarAccess.getScenarioAccess().getModelImportsImportStatementParserRuleCall_3_0_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_3);
                            lv_modelImports_3_0=ruleImportStatement();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getScenarioRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"modelImports",
                                    		lv_modelImports_3_0, 
                                    		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.ImportStatement");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTestScenarioLang.g:127:6: ( (lv_classImports_4_0= ruleImportJavaStatement ) )
                            {
                            // InternalTestScenarioLang.g:127:6: ( (lv_classImports_4_0= ruleImportJavaStatement ) )
                            // InternalTestScenarioLang.g:128:1: (lv_classImports_4_0= ruleImportJavaStatement )
                            {
                            // InternalTestScenarioLang.g:128:1: (lv_classImports_4_0= ruleImportJavaStatement )
                            // InternalTestScenarioLang.g:129:3: lv_classImports_4_0= ruleImportJavaStatement
                            {
                             
                            	        newCompositeNode(grammarAccess.getScenarioAccess().getClassImportsImportJavaStatementParserRuleCall_3_0_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_3);
                            lv_classImports_4_0=ruleImportJavaStatement();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getScenarioRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"classImports",
                                    		lv_classImports_4_0, 
                                    		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.ImportJavaStatement");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // InternalTestScenarioLang.g:145:3: ( ( (lv_modelImports_5_0= ruleImportStatement ) ) | ( (lv_classImports_6_0= ruleImportJavaStatement ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==12) ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>=15 && LA3_0<=16)) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalTestScenarioLang.g:145:4: ( (lv_modelImports_5_0= ruleImportStatement ) )
                    	    {
                    	    // InternalTestScenarioLang.g:145:4: ( (lv_modelImports_5_0= ruleImportStatement ) )
                    	    // InternalTestScenarioLang.g:146:1: (lv_modelImports_5_0= ruleImportStatement )
                    	    {
                    	    // InternalTestScenarioLang.g:146:1: (lv_modelImports_5_0= ruleImportStatement )
                    	    // InternalTestScenarioLang.g:147:3: lv_modelImports_5_0= ruleImportStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getScenarioAccess().getModelImportsImportStatementParserRuleCall_3_1_0_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_modelImports_5_0=ruleImportStatement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getScenarioRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modelImports",
                    	            		lv_modelImports_5_0, 
                    	            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.ImportStatement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalTestScenarioLang.g:164:6: ( (lv_classImports_6_0= ruleImportJavaStatement ) )
                    	    {
                    	    // InternalTestScenarioLang.g:164:6: ( (lv_classImports_6_0= ruleImportJavaStatement ) )
                    	    // InternalTestScenarioLang.g:165:1: (lv_classImports_6_0= ruleImportJavaStatement )
                    	    {
                    	    // InternalTestScenarioLang.g:165:1: (lv_classImports_6_0= ruleImportJavaStatement )
                    	    // InternalTestScenarioLang.g:166:3: lv_classImports_6_0= ruleImportJavaStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getScenarioAccess().getClassImportsImportJavaStatementParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_classImports_6_0=ruleImportJavaStatement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getScenarioRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"classImports",
                    	            		lv_classImports_6_0, 
                    	            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.ImportJavaStatement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTestScenarioLang.g:182:6: ( ( (lv_variables_7_0= ruleObjectVariable ) ) ( (lv_variables_8_0= ruleObjectVariable ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalTestScenarioLang.g:182:7: ( (lv_variables_7_0= ruleObjectVariable ) ) ( (lv_variables_8_0= ruleObjectVariable ) )*
                    {
                    // InternalTestScenarioLang.g:182:7: ( (lv_variables_7_0= ruleObjectVariable ) )
                    // InternalTestScenarioLang.g:183:1: (lv_variables_7_0= ruleObjectVariable )
                    {
                    // InternalTestScenarioLang.g:183:1: (lv_variables_7_0= ruleObjectVariable )
                    // InternalTestScenarioLang.g:184:3: lv_variables_7_0= ruleObjectVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenarioAccess().getVariablesObjectVariableParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_3);
                    lv_variables_7_0=ruleObjectVariable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenarioRule());
                    	        }
                           		add(
                           			current, 
                           			"variables",
                            		lv_variables_7_0, 
                            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.ObjectVariable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalTestScenarioLang.g:200:2: ( (lv_variables_8_0= ruleObjectVariable ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==17) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalTestScenarioLang.g:201:1: (lv_variables_8_0= ruleObjectVariable )
                    	    {
                    	    // InternalTestScenarioLang.g:201:1: (lv_variables_8_0= ruleObjectVariable )
                    	    // InternalTestScenarioLang.g:202:3: lv_variables_8_0= ruleObjectVariable
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getScenarioAccess().getVariablesObjectVariableParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_variables_8_0=ruleObjectVariable();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getScenarioRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"variables",
                    	            		lv_variables_8_0, 
                    	            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.ObjectVariable");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTestScenarioLang.g:218:5: ( (lv_statementSequence_9_0= ruleStatement ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21||LA7_0==23) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalTestScenarioLang.g:219:1: (lv_statementSequence_9_0= ruleStatement )
            	    {
            	    // InternalTestScenarioLang.g:219:1: (lv_statementSequence_9_0= ruleStatement )
            	    // InternalTestScenarioLang.g:220:3: lv_statementSequence_9_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenarioAccess().getStatementSequenceStatementParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_statementSequence_9_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenarioRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statementSequence",
            	            		lv_statementSequence_9_0, 
            	            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleImportStatement"
    // InternalTestScenarioLang.g:244:1: entryRuleImportStatement returns [EObject current=null] : iv_ruleImportStatement= ruleImportStatement EOF ;
    public final EObject entryRuleImportStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStatement = null;


        try {
            // InternalTestScenarioLang.g:245:2: (iv_ruleImportStatement= ruleImportStatement EOF )
            // InternalTestScenarioLang.g:246:2: iv_ruleImportStatement= ruleImportStatement EOF
            {
             newCompositeNode(grammarAccess.getImportStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleImportStatement=ruleImportStatement();

            state._fsp--;

             current =iv_ruleImportStatement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportStatement"


    // $ANTLR start "ruleImportStatement"
    // InternalTestScenarioLang.g:253:1: ruleImportStatement returns [EObject current=null] : (otherlv_0= 'importModel' ( (lv_importURI_1_0= ruleEString ) ) ( ( (lv_alias_2_0= ';' ) ) | (otherlv_3= 'as' ( (lv_alias_4_0= ruleEString ) ) otherlv_5= ';' ) ) ) ;
    public final EObject ruleImportStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_alias_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_importURI_1_0 = null;

        AntlrDatatypeRuleToken lv_alias_4_0 = null;


         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:256:28: ( (otherlv_0= 'importModel' ( (lv_importURI_1_0= ruleEString ) ) ( ( (lv_alias_2_0= ';' ) ) | (otherlv_3= 'as' ( (lv_alias_4_0= ruleEString ) ) otherlv_5= ';' ) ) ) )
            // InternalTestScenarioLang.g:257:1: (otherlv_0= 'importModel' ( (lv_importURI_1_0= ruleEString ) ) ( ( (lv_alias_2_0= ';' ) ) | (otherlv_3= 'as' ( (lv_alias_4_0= ruleEString ) ) otherlv_5= ';' ) ) )
            {
            // InternalTestScenarioLang.g:257:1: (otherlv_0= 'importModel' ( (lv_importURI_1_0= ruleEString ) ) ( ( (lv_alias_2_0= ';' ) ) | (otherlv_3= 'as' ( (lv_alias_4_0= ruleEString ) ) otherlv_5= ';' ) ) )
            // InternalTestScenarioLang.g:257:3: otherlv_0= 'importModel' ( (lv_importURI_1_0= ruleEString ) ) ( ( (lv_alias_2_0= ';' ) ) | (otherlv_3= 'as' ( (lv_alias_4_0= ruleEString ) ) otherlv_5= ';' ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getImportStatementAccess().getImportModelKeyword_0());
                
            // InternalTestScenarioLang.g:261:1: ( (lv_importURI_1_0= ruleEString ) )
            // InternalTestScenarioLang.g:262:1: (lv_importURI_1_0= ruleEString )
            {
            // InternalTestScenarioLang.g:262:1: (lv_importURI_1_0= ruleEString )
            // InternalTestScenarioLang.g:263:3: lv_importURI_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getImportStatementAccess().getImportURIEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_6);
            lv_importURI_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportStatementRule());
            	        }
                   		set(
                   			current, 
                   			"importURI",
                    		lv_importURI_1_0, 
                    		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTestScenarioLang.g:279:2: ( ( (lv_alias_2_0= ';' ) ) | (otherlv_3= 'as' ( (lv_alias_4_0= ruleEString ) ) otherlv_5= ';' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            else if ( (LA8_0==14) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalTestScenarioLang.g:279:3: ( (lv_alias_2_0= ';' ) )
                    {
                    // InternalTestScenarioLang.g:279:3: ( (lv_alias_2_0= ';' ) )
                    // InternalTestScenarioLang.g:280:1: (lv_alias_2_0= ';' )
                    {
                    // InternalTestScenarioLang.g:280:1: (lv_alias_2_0= ';' )
                    // InternalTestScenarioLang.g:281:3: lv_alias_2_0= ';'
                    {
                    lv_alias_2_0=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_alias_2_0, grammarAccess.getImportStatementAccess().getAliasSemicolonKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getImportStatementRule());
                    	        }
                           		setWithLastConsumed(current, "alias", lv_alias_2_0, ";");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:295:6: (otherlv_3= 'as' ( (lv_alias_4_0= ruleEString ) ) otherlv_5= ';' )
                    {
                    // InternalTestScenarioLang.g:295:6: (otherlv_3= 'as' ( (lv_alias_4_0= ruleEString ) ) otherlv_5= ';' )
                    // InternalTestScenarioLang.g:295:8: otherlv_3= 'as' ( (lv_alias_4_0= ruleEString ) ) otherlv_5= ';'
                    {
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_3, grammarAccess.getImportStatementAccess().getAsKeyword_2_1_0());
                        
                    // InternalTestScenarioLang.g:299:1: ( (lv_alias_4_0= ruleEString ) )
                    // InternalTestScenarioLang.g:300:1: (lv_alias_4_0= ruleEString )
                    {
                    // InternalTestScenarioLang.g:300:1: (lv_alias_4_0= ruleEString )
                    // InternalTestScenarioLang.g:301:3: lv_alias_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportStatementAccess().getAliasEStringParserRuleCall_2_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_alias_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getImportStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"alias",
                            		lv_alias_4_0, 
                            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_5, grammarAccess.getImportStatementAccess().getSemicolonKeyword_2_1_2());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportStatement"


    // $ANTLR start "entryRuleImportJavaStatement"
    // InternalTestScenarioLang.g:329:1: entryRuleImportJavaStatement returns [EObject current=null] : iv_ruleImportJavaStatement= ruleImportJavaStatement EOF ;
    public final EObject entryRuleImportJavaStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportJavaStatement = null;


        try {
            // InternalTestScenarioLang.g:330:2: (iv_ruleImportJavaStatement= ruleImportJavaStatement EOF )
            // InternalTestScenarioLang.g:331:2: iv_ruleImportJavaStatement= ruleImportJavaStatement EOF
            {
             newCompositeNode(grammarAccess.getImportJavaStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleImportJavaStatement=ruleImportJavaStatement();

            state._fsp--;

             current =iv_ruleImportJavaStatement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportJavaStatement"


    // $ANTLR start "ruleImportJavaStatement"
    // InternalTestScenarioLang.g:338:1: ruleImportJavaStatement returns [EObject current=null] : ( ( (otherlv_0= 'importClass' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) | (otherlv_2= 'importPackage' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) ) ) otherlv_4= ';' ) ;
    public final EObject ruleImportJavaStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;

        AntlrDatatypeRuleToken lv_importedNamespace_3_0 = null;


         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:341:28: ( ( ( (otherlv_0= 'importClass' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) | (otherlv_2= 'importPackage' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) ) ) otherlv_4= ';' ) )
            // InternalTestScenarioLang.g:342:1: ( ( (otherlv_0= 'importClass' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) | (otherlv_2= 'importPackage' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) ) ) otherlv_4= ';' )
            {
            // InternalTestScenarioLang.g:342:1: ( ( (otherlv_0= 'importClass' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) | (otherlv_2= 'importPackage' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) ) ) otherlv_4= ';' )
            // InternalTestScenarioLang.g:342:2: ( (otherlv_0= 'importClass' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) | (otherlv_2= 'importPackage' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) ) ) otherlv_4= ';'
            {
            // InternalTestScenarioLang.g:342:2: ( (otherlv_0= 'importClass' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) ) | (otherlv_2= 'importPackage' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            else if ( (LA9_0==16) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalTestScenarioLang.g:342:3: (otherlv_0= 'importClass' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
                    {
                    // InternalTestScenarioLang.g:342:3: (otherlv_0= 'importClass' ( (lv_importedNamespace_1_0= ruleQualifiedName ) ) )
                    // InternalTestScenarioLang.g:342:5: otherlv_0= 'importClass' ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
                    {
                    otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_0, grammarAccess.getImportJavaStatementAccess().getImportClassKeyword_0_0_0());
                        
                    // InternalTestScenarioLang.g:346:1: ( (lv_importedNamespace_1_0= ruleQualifiedName ) )
                    // InternalTestScenarioLang.g:347:1: (lv_importedNamespace_1_0= ruleQualifiedName )
                    {
                    // InternalTestScenarioLang.g:347:1: (lv_importedNamespace_1_0= ruleQualifiedName )
                    // InternalTestScenarioLang.g:348:3: lv_importedNamespace_1_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportJavaStatementAccess().getImportedNamespaceQualifiedNameParserRuleCall_0_0_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_importedNamespace_1_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getImportJavaStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"importedNamespace",
                            		lv_importedNamespace_1_0, 
                            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.QualifiedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:365:6: (otherlv_2= 'importPackage' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )
                    {
                    // InternalTestScenarioLang.g:365:6: (otherlv_2= 'importPackage' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )
                    // InternalTestScenarioLang.g:365:8: otherlv_2= 'importPackage' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) )
                    {
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_8); 

                        	newLeafNode(otherlv_2, grammarAccess.getImportJavaStatementAccess().getImportPackageKeyword_0_1_0());
                        
                    // InternalTestScenarioLang.g:369:1: ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) )
                    // InternalTestScenarioLang.g:370:1: (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard )
                    {
                    // InternalTestScenarioLang.g:370:1: (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard )
                    // InternalTestScenarioLang.g:371:3: lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportJavaStatementAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_0_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_importedNamespace_3_0=ruleQualifiedNameWithWildCard();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getImportJavaStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"importedNamespace",
                            		lv_importedNamespace_3_0, 
                            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.QualifiedNameWithWildCard");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getImportJavaStatementAccess().getSemicolonKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportJavaStatement"


    // $ANTLR start "entryRuleObjectVariable"
    // InternalTestScenarioLang.g:399:1: entryRuleObjectVariable returns [EObject current=null] : iv_ruleObjectVariable= ruleObjectVariable EOF ;
    public final EObject entryRuleObjectVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectVariable = null;


        try {
            // InternalTestScenarioLang.g:400:2: (iv_ruleObjectVariable= ruleObjectVariable EOF )
            // InternalTestScenarioLang.g:401:2: iv_ruleObjectVariable= ruleObjectVariable EOF
            {
             newCompositeNode(grammarAccess.getObjectVariableRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleObjectVariable=ruleObjectVariable();

            state._fsp--;

             current =iv_ruleObjectVariable; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectVariable"


    // $ANTLR start "ruleObjectVariable"
    // InternalTestScenarioLang.g:408:1: ruleObjectVariable returns [EObject current=null] : (otherlv_0= 'Variable' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_type_3_0= ruleJvmTypeReference ) ) otherlv_4= ';' ) ;
    public final EObject ruleObjectVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:411:28: ( (otherlv_0= 'Variable' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_type_3_0= ruleJvmTypeReference ) ) otherlv_4= ';' ) )
            // InternalTestScenarioLang.g:412:1: (otherlv_0= 'Variable' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_type_3_0= ruleJvmTypeReference ) ) otherlv_4= ';' )
            {
            // InternalTestScenarioLang.g:412:1: (otherlv_0= 'Variable' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_type_3_0= ruleJvmTypeReference ) ) otherlv_4= ';' )
            // InternalTestScenarioLang.g:412:3: otherlv_0= 'Variable' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_type_3_0= ruleJvmTypeReference ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getObjectVariableAccess().getVariableKeyword_0());
                
            // InternalTestScenarioLang.g:416:1: ( (lv_name_1_0= ruleEString ) )
            // InternalTestScenarioLang.g:417:1: (lv_name_1_0= ruleEString )
            {
            // InternalTestScenarioLang.g:417:1: (lv_name_1_0= ruleEString )
            // InternalTestScenarioLang.g:418:3: lv_name_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getObjectVariableAccess().getNameEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_9);
            lv_name_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getObjectVariableRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_2, grammarAccess.getObjectVariableAccess().getColonKeyword_2());
                
            // InternalTestScenarioLang.g:438:1: ( (lv_type_3_0= ruleJvmTypeReference ) )
            // InternalTestScenarioLang.g:439:1: (lv_type_3_0= ruleJvmTypeReference )
            {
            // InternalTestScenarioLang.g:439:1: (lv_type_3_0= ruleJvmTypeReference )
            // InternalTestScenarioLang.g:440:3: lv_type_3_0= ruleJvmTypeReference
            {
             
            	        newCompositeNode(grammarAccess.getObjectVariableAccess().getTypeJvmTypeReferenceParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_7);
            lv_type_3_0=ruleJvmTypeReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getObjectVariableRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_3_0, 
                    		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.JvmTypeReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getObjectVariableAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectVariable"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // InternalTestScenarioLang.g:468:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // InternalTestScenarioLang.g:469:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // InternalTestScenarioLang.g:470:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildCard.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // InternalTestScenarioLang.g:477:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:480:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) )
            // InternalTestScenarioLang.g:481:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
            {
            // InternalTestScenarioLang.g:481:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
            // InternalTestScenarioLang.g:482:5: this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*'
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_10);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,19,FollowSets000.FOLLOW_11); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopKeyword_1()); 
                
            kw=(Token)match(input,20,FollowSets000.FOLLOW_2); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getAsteriskKeyword_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalTestScenarioLang.g:512:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalTestScenarioLang.g:513:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalTestScenarioLang.g:514:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalTestScenarioLang.g:521:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:524:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTestScenarioLang.g:525:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTestScenarioLang.g:525:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTestScenarioLang.g:525:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // InternalTestScenarioLang.g:532:1: (kw= '.' this_ID_2= RULE_ID )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==19) ) {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2==RULE_ID) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // InternalTestScenarioLang.g:533:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,19,FollowSets000.FOLLOW_8); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleJvmTypeReference"
    // InternalTestScenarioLang.g:553:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // InternalTestScenarioLang.g:554:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // InternalTestScenarioLang.g:555:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
             newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;

             current =iv_ruleJvmTypeReference; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // InternalTestScenarioLang.g:562:1: ruleJvmTypeReference returns [EObject current=null] : ( () ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:565:28: ( ( () ( ( ruleQualifiedName ) ) ) )
            // InternalTestScenarioLang.g:566:1: ( () ( ( ruleQualifiedName ) ) )
            {
            // InternalTestScenarioLang.g:566:1: ( () ( ( ruleQualifiedName ) ) )
            // InternalTestScenarioLang.g:566:2: () ( ( ruleQualifiedName ) )
            {
            // InternalTestScenarioLang.g:566:2: ()
            // InternalTestScenarioLang.g:567:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getJvmTypeReferenceAccess().getJvmAnyTypeReferenceAction_0(),
                        current);
                

            }

            // InternalTestScenarioLang.g:572:2: ( ( ruleQualifiedName ) )
            // InternalTestScenarioLang.g:573:1: ( ruleQualifiedName )
            {
            // InternalTestScenarioLang.g:573:1: ( ruleQualifiedName )
            // InternalTestScenarioLang.g:574:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJvmTypeReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getTypeJvmTypeCrossReference_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleStatement"
    // InternalTestScenarioLang.g:595:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalTestScenarioLang.g:596:2: (iv_ruleStatement= ruleStatement EOF )
            // InternalTestScenarioLang.g:597:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalTestScenarioLang.g:604:1: ruleStatement returns [EObject current=null] : (this_MseStatement_0= ruleMseStatement | this_RewritingRuleCallStatement_1= ruleRewritingRuleCallStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_MseStatement_0 = null;

        EObject this_RewritingRuleCallStatement_1 = null;


         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:607:28: ( (this_MseStatement_0= ruleMseStatement | this_RewritingRuleCallStatement_1= ruleRewritingRuleCallStatement ) )
            // InternalTestScenarioLang.g:608:1: (this_MseStatement_0= ruleMseStatement | this_RewritingRuleCallStatement_1= ruleRewritingRuleCallStatement )
            {
            // InternalTestScenarioLang.g:608:1: (this_MseStatement_0= ruleMseStatement | this_RewritingRuleCallStatement_1= ruleRewritingRuleCallStatement )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            else if ( (LA11_0==23) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalTestScenarioLang.g:609:5: this_MseStatement_0= ruleMseStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getMseStatementParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MseStatement_0=ruleMseStatement();

                    state._fsp--;

                     
                            current = this_MseStatement_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:619:5: this_RewritingRuleCallStatement_1= ruleRewritingRuleCallStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getRewritingRuleCallStatementParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RewritingRuleCallStatement_1=ruleRewritingRuleCallStatement();

                    state._fsp--;

                     
                            current = this_RewritingRuleCallStatement_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleMseStatement"
    // InternalTestScenarioLang.g:635:1: entryRuleMseStatement returns [EObject current=null] : iv_ruleMseStatement= ruleMseStatement EOF ;
    public final EObject entryRuleMseStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMseStatement = null;


        try {
            // InternalTestScenarioLang.g:636:2: (iv_ruleMseStatement= ruleMseStatement EOF )
            // InternalTestScenarioLang.g:637:2: iv_ruleMseStatement= ruleMseStatement EOF
            {
             newCompositeNode(grammarAccess.getMseStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMseStatement=ruleMseStatement();

            state._fsp--;

             current =iv_ruleMseStatement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMseStatement"


    // $ANTLR start "ruleMseStatement"
    // InternalTestScenarioLang.g:644:1: ruleMseStatement returns [EObject current=null] : (otherlv_0= 'expect' () ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'and' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= ';' )? ) ;
    public final EObject ruleMseStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:647:28: ( (otherlv_0= 'expect' () ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'and' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= ';' )? ) )
            // InternalTestScenarioLang.g:648:1: (otherlv_0= 'expect' () ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'and' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= ';' )? )
            {
            // InternalTestScenarioLang.g:648:1: (otherlv_0= 'expect' () ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'and' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= ';' )? )
            // InternalTestScenarioLang.g:648:3: otherlv_0= 'expect' () ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'and' ( (otherlv_4= RULE_ID ) ) )* (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getMseStatementAccess().getExpectKeyword_0());
                
            // InternalTestScenarioLang.g:652:1: ()
            // InternalTestScenarioLang.g:653:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMseStatementAccess().getMseStatementAction_1(),
                        current);
                

            }

            // InternalTestScenarioLang.g:658:2: ( (otherlv_2= RULE_ID ) )
            // InternalTestScenarioLang.g:659:1: (otherlv_2= RULE_ID )
            {
            // InternalTestScenarioLang.g:659:1: (otherlv_2= RULE_ID )
            // InternalTestScenarioLang.g:660:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMseStatementRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            		newLeafNode(otherlv_2, grammarAccess.getMseStatementAccess().getClocksClockCrossReference_2_0()); 
            	

            }


            }

            // InternalTestScenarioLang.g:671:2: (otherlv_3= 'and' ( (otherlv_4= RULE_ID ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==22) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalTestScenarioLang.g:671:4: otherlv_3= 'and' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_8); 

            	        	newLeafNode(otherlv_3, grammarAccess.getMseStatementAccess().getAndKeyword_3_0());
            	        
            	    // InternalTestScenarioLang.g:675:1: ( (otherlv_4= RULE_ID ) )
            	    // InternalTestScenarioLang.g:676:1: (otherlv_4= RULE_ID )
            	    {
            	    // InternalTestScenarioLang.g:676:1: (otherlv_4= RULE_ID )
            	    // InternalTestScenarioLang.g:677:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getMseStatementRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            	    		newLeafNode(otherlv_4, grammarAccess.getMseStatementAccess().getClocksClockCrossReference_3_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // InternalTestScenarioLang.g:688:4: (otherlv_5= ';' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==13) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTestScenarioLang.g:688:6: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_5, grammarAccess.getMseStatementAccess().getSemicolonKeyword_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMseStatement"


    // $ANTLR start "entryRuleRewritingRuleCallStatement"
    // InternalTestScenarioLang.g:700:1: entryRuleRewritingRuleCallStatement returns [EObject current=null] : iv_ruleRewritingRuleCallStatement= ruleRewritingRuleCallStatement EOF ;
    public final EObject entryRuleRewritingRuleCallStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRewritingRuleCallStatement = null;


        try {
            // InternalTestScenarioLang.g:701:2: (iv_ruleRewritingRuleCallStatement= ruleRewritingRuleCallStatement EOF )
            // InternalTestScenarioLang.g:702:2: iv_ruleRewritingRuleCallStatement= ruleRewritingRuleCallStatement EOF
            {
             newCompositeNode(grammarAccess.getRewritingRuleCallStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRewritingRuleCallStatement=ruleRewritingRuleCallStatement();

            state._fsp--;

             current =iv_ruleRewritingRuleCallStatement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRewritingRuleCallStatement"


    // $ANTLR start "ruleRewritingRuleCallStatement"
    // InternalTestScenarioLang.g:709:1: ruleRewritingRuleCallStatement returns [EObject current=null] : (otherlv_0= 'execute' () ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )* )* otherlv_9= ')' )? ) (otherlv_10= ';' )? ) ;
    public final EObject ruleRewritingRuleCallStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_parameters_6_0 = null;

        EObject lv_parameters_8_0 = null;


         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:712:28: ( (otherlv_0= 'execute' () ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )* )* otherlv_9= ')' )? ) (otherlv_10= ';' )? ) )
            // InternalTestScenarioLang.g:713:1: (otherlv_0= 'execute' () ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )* )* otherlv_9= ')' )? ) (otherlv_10= ';' )? )
            {
            // InternalTestScenarioLang.g:713:1: (otherlv_0= 'execute' () ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )* )* otherlv_9= ')' )? ) (otherlv_10= ';' )? )
            // InternalTestScenarioLang.g:713:3: otherlv_0= 'execute' () ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )* )* otherlv_9= ')' )? ) (otherlv_10= ';' )?
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_0, grammarAccess.getRewritingRuleCallStatementAccess().getExecuteKeyword_0());
                
            // InternalTestScenarioLang.g:717:1: ()
            // InternalTestScenarioLang.g:718:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRewritingRuleCallStatementAccess().getRewritingRuleCallStatementAction_1(),
                        current);
                

            }

            // InternalTestScenarioLang.g:723:2: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )* )* otherlv_9= ')' )? )
            // InternalTestScenarioLang.g:723:3: ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )* )* otherlv_9= ')' )?
            {
            // InternalTestScenarioLang.g:723:3: ( (otherlv_2= RULE_ID ) )
            // InternalTestScenarioLang.g:724:1: (otherlv_2= RULE_ID )
            {
            // InternalTestScenarioLang.g:724:1: (otherlv_2= RULE_ID )
            // InternalTestScenarioLang.g:725:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRewritingRuleCallStatementRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            		newLeafNode(otherlv_2, grammarAccess.getRewritingRuleCallStatementAccess().getObjectVariableObjectVariableCrossReference_2_0_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_3, grammarAccess.getRewritingRuleCallStatementAccess().getFullStopKeyword_2_1());
                
            // InternalTestScenarioLang.g:740:1: ( (otherlv_4= RULE_ID ) )
            // InternalTestScenarioLang.g:741:1: (otherlv_4= RULE_ID )
            {
            // InternalTestScenarioLang.g:741:1: (otherlv_4= RULE_ID )
            // InternalTestScenarioLang.g:742:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRewritingRuleCallStatementRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            		newLeafNode(otherlv_4, grammarAccess.getRewritingRuleCallStatementAccess().getMethodJvmOperationCrossReference_2_2_0()); 
            	

            }


            }

            // InternalTestScenarioLang.g:753:2: (otherlv_5= '(' ( ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )* )* otherlv_9= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTestScenarioLang.g:753:4: otherlv_5= '(' ( ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )* )* otherlv_9= ')'
                    {
                    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_15); 

                        	newLeafNode(otherlv_5, grammarAccess.getRewritingRuleCallStatementAccess().getLeftParenthesisKeyword_2_3_0());
                        
                    // InternalTestScenarioLang.g:757:1: ( ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )* )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_INT)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalTestScenarioLang.g:757:2: ( (lv_parameters_6_0= ruleVariable ) ) (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )*
                    	    {
                    	    // InternalTestScenarioLang.g:757:2: ( (lv_parameters_6_0= ruleVariable ) )
                    	    // InternalTestScenarioLang.g:758:1: (lv_parameters_6_0= ruleVariable )
                    	    {
                    	    // InternalTestScenarioLang.g:758:1: (lv_parameters_6_0= ruleVariable )
                    	    // InternalTestScenarioLang.g:759:3: lv_parameters_6_0= ruleVariable
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRewritingRuleCallStatementAccess().getParametersVariableParserRuleCall_2_3_1_0_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_16);
                    	    lv_parameters_6_0=ruleVariable();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRewritingRuleCallStatementRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parameters",
                    	            		lv_parameters_6_0, 
                    	            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.Variable");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	    // InternalTestScenarioLang.g:775:2: (otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) ) )*
                    	    loop14:
                    	    do {
                    	        int alt14=2;
                    	        int LA14_0 = input.LA(1);

                    	        if ( (LA14_0==25) ) {
                    	            alt14=1;
                    	        }


                    	        switch (alt14) {
                    	    	case 1 :
                    	    	    // InternalTestScenarioLang.g:775:4: otherlv_7= ',' ( (lv_parameters_8_0= ruleVariable ) )
                    	    	    {
                    	    	    otherlv_7=(Token)match(input,25,FollowSets000.FOLLOW_17); 

                    	    	        	newLeafNode(otherlv_7, grammarAccess.getRewritingRuleCallStatementAccess().getCommaKeyword_2_3_1_1_0());
                    	    	        
                    	    	    // InternalTestScenarioLang.g:779:1: ( (lv_parameters_8_0= ruleVariable ) )
                    	    	    // InternalTestScenarioLang.g:780:1: (lv_parameters_8_0= ruleVariable )
                    	    	    {
                    	    	    // InternalTestScenarioLang.g:780:1: (lv_parameters_8_0= ruleVariable )
                    	    	    // InternalTestScenarioLang.g:781:3: lv_parameters_8_0= ruleVariable
                    	    	    {
                    	    	     
                    	    	    	        newCompositeNode(grammarAccess.getRewritingRuleCallStatementAccess().getParametersVariableParserRuleCall_2_3_1_1_1_0()); 
                    	    	    	    
                    	    	    pushFollow(FollowSets000.FOLLOW_16);
                    	    	    lv_parameters_8_0=ruleVariable();

                    	    	    state._fsp--;


                    	    	    	        if (current==null) {
                    	    	    	            current = createModelElementForParent(grammarAccess.getRewritingRuleCallStatementRule());
                    	    	    	        }
                    	    	           		add(
                    	    	           			current, 
                    	    	           			"parameters",
                    	    	            		lv_parameters_8_0, 
                    	    	            		"org.eclipse.gemoc.execution.moccml.testscenariolang.xtext.TestScenarioLang.Variable");
                    	    	    	        afterParserOrEnumRuleCall();
                    	    	    	    

                    	    	    }


                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop14;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_18); 

                        	newLeafNode(otherlv_9, grammarAccess.getRewritingRuleCallStatementAccess().getRightParenthesisKeyword_2_3_2());
                        

                    }
                    break;

            }


            }

            // InternalTestScenarioLang.g:801:4: (otherlv_10= ';' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==13) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTestScenarioLang.g:801:6: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_10, grammarAccess.getRewritingRuleCallStatementAccess().getSemicolonKeyword_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRewritingRuleCallStatement"


    // $ANTLR start "entryRuleVariable"
    // InternalTestScenarioLang.g:813:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalTestScenarioLang.g:814:2: (iv_ruleVariable= ruleVariable EOF )
            // InternalTestScenarioLang.g:815:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalTestScenarioLang.g:822:1: ruleVariable returns [EObject current=null] : (this_IntegerLiteral_0= ruleIntegerLiteral | this_StringLiteral_1= ruleStringLiteral | this_EObjectRef_2= ruleEObjectRef ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteral_0 = null;

        EObject this_StringLiteral_1 = null;

        EObject this_EObjectRef_2 = null;


         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:825:28: ( (this_IntegerLiteral_0= ruleIntegerLiteral | this_StringLiteral_1= ruleStringLiteral | this_EObjectRef_2= ruleEObjectRef ) )
            // InternalTestScenarioLang.g:826:1: (this_IntegerLiteral_0= ruleIntegerLiteral | this_StringLiteral_1= ruleStringLiteral | this_EObjectRef_2= ruleEObjectRef )
            {
            // InternalTestScenarioLang.g:826:1: (this_IntegerLiteral_0= ruleIntegerLiteral | this_StringLiteral_1= ruleStringLiteral | this_EObjectRef_2= ruleEObjectRef )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt18=1;
                }
                break;
            case RULE_STRING:
                {
                alt18=2;
                }
                break;
            case RULE_ID:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalTestScenarioLang.g:827:5: this_IntegerLiteral_0= ruleIntegerLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getVariableAccess().getIntegerLiteralParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IntegerLiteral_0=ruleIntegerLiteral();

                    state._fsp--;

                     
                            current = this_IntegerLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:837:5: this_StringLiteral_1= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getVariableAccess().getStringLiteralParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_StringLiteral_1=ruleStringLiteral();

                    state._fsp--;

                     
                            current = this_StringLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalTestScenarioLang.g:847:5: this_EObjectRef_2= ruleEObjectRef
                    {
                     
                            newCompositeNode(grammarAccess.getVariableAccess().getEObjectRefParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EObjectRef_2=ruleEObjectRef();

                    state._fsp--;

                     
                            current = this_EObjectRef_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleEObjectRef"
    // InternalTestScenarioLang.g:863:1: entryRuleEObjectRef returns [EObject current=null] : iv_ruleEObjectRef= ruleEObjectRef EOF ;
    public final EObject entryRuleEObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEObjectRef = null;


        try {
            // InternalTestScenarioLang.g:864:2: (iv_ruleEObjectRef= ruleEObjectRef EOF )
            // InternalTestScenarioLang.g:865:2: iv_ruleEObjectRef= ruleEObjectRef EOF
            {
             newCompositeNode(grammarAccess.getEObjectRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEObjectRef=ruleEObjectRef();

            state._fsp--;

             current =iv_ruleEObjectRef; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEObjectRef"


    // $ANTLR start "ruleEObjectRef"
    // InternalTestScenarioLang.g:872:1: ruleEObjectRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleEObjectRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:875:28: ( ( ( ruleQualifiedName ) ) )
            // InternalTestScenarioLang.g:876:1: ( ( ruleQualifiedName ) )
            {
            // InternalTestScenarioLang.g:876:1: ( ( ruleQualifiedName ) )
            // InternalTestScenarioLang.g:877:1: ( ruleQualifiedName )
            {
            // InternalTestScenarioLang.g:877:1: ( ruleQualifiedName )
            // InternalTestScenarioLang.g:878:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEObjectRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getEObjectRefAccess().getObjectEObjectCrossReference_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEObjectRef"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalTestScenarioLang.g:899:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalTestScenarioLang.g:900:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalTestScenarioLang.g:901:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalTestScenarioLang.g:908:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:911:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalTestScenarioLang.g:912:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalTestScenarioLang.g:912:1: ( (lv_value_0_0= RULE_STRING ) )
            // InternalTestScenarioLang.g:913:1: (lv_value_0_0= RULE_STRING )
            {
            // InternalTestScenarioLang.g:913:1: (lv_value_0_0= RULE_STRING )
            // InternalTestScenarioLang.g:914:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleIntegerLiteral"
    // InternalTestScenarioLang.g:938:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // InternalTestScenarioLang.g:939:2: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // InternalTestScenarioLang.g:940:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntegerLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();

            state._fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerLiteral"


    // $ANTLR start "ruleIntegerLiteral"
    // InternalTestScenarioLang.g:947:1: ruleIntegerLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:950:28: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalTestScenarioLang.g:951:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalTestScenarioLang.g:951:1: ( (lv_value_0_0= RULE_INT ) )
            // InternalTestScenarioLang.g:952:1: (lv_value_0_0= RULE_INT )
            {
            // InternalTestScenarioLang.g:952:1: (lv_value_0_0= RULE_INT )
            // InternalTestScenarioLang.g:953:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getIntegerLiteralAccess().getValueINTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIntegerLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerLiteral"


    // $ANTLR start "entryRuleEString"
    // InternalTestScenarioLang.g:977:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalTestScenarioLang.g:978:2: (iv_ruleEString= ruleEString EOF )
            // InternalTestScenarioLang.g:979:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalTestScenarioLang.g:986:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalTestScenarioLang.g:989:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalTestScenarioLang.g:990:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalTestScenarioLang.g:990:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_STRING) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_ID) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalTestScenarioLang.g:990:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalTestScenarioLang.g:998:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000A39030L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000A39032L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000402002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001002002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000070L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000006000070L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000070L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000002002L});
    }


}