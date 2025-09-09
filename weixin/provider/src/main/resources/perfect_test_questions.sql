/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : weixin

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 06/09/2025 22:55:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for perfect_test_questions
-- ----------------------------
DROP TABLE IF EXISTS `perfect_test_questions`;
CREATE TABLE `perfect_test_questions`  (
  `biz_type_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务类型代码',
  `biz_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1-第一板块 2-第二版块 3-第三版块',
  `question_no` int NOT NULL COMMENT '题目编号（1-15）',
  `question_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '题目题干文本',
  PRIMARY KEY (`biz_type_code`, `biz_type`, `question_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '完美性测试题目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of perfect_test_questions
-- ----------------------------
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 1, '当面对一个有挑战性的目标时，我通常会设定清晰的计划并努力去完成它。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 2, '我常常为自己设定较高的标准，并努力去达到这些标准。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 3, '我更倾向于选择那些能让我展现能力并获得认可的任务。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 4, '即使没有外界压力，我也会主动追求进步和提升自我。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 5, '我经常思考如何能在工作或学习中做得比别人更好。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 6, '我倾向于把失败看作是暂时的，只要继续努力就能成功。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 7, '我非常在意别人对我工作成果的评价，希望得到肯定。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 8, '我通常会优先完成那些能带来成就感的任务。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 9, '我愿意牺牲休息时间，以确保任务能够高质量完成。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 10, '我常常与自己比较，希望每次都能比上一次做得更好。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 11, '我认为持续努力和自我提升是成功的关键。');
INSERT INTO `perfect_test_questions` VALUES ('AchievingType', '1', 12, '我享受通过努力达成目标后带来的满足感。');
INSERT INTO `perfect_test_questions` VALUES ('ActiveType', '1', 1, '我通常喜欢与人交往，享受社交活动带来的乐趣。');
INSERT INTO `perfect_test_questions` VALUES ('ActiveType', '1', 2, '我是一个精力充沛的人，很少感到疲倦或无聊。');
INSERT INTO `perfect_test_questions` VALUES ('ActiveType', '1', 3, '我习惯快速做出决定，并迅速采取行动。');
INSERT INTO `perfect_test_questions` VALUES ('ActiveType', '1', 4, '在聚会或集体活动中，我通常是主动发言和带动气氛的人。');
INSERT INTO `perfect_test_questions` VALUES ('ActiveType', '1', 5, '我非常喜欢与人面对面交流，而不是通过文字或线上方式。');
INSERT INTO `perfect_test_questions` VALUES ('ActiveType', '1', 6, '我通常充满热情，对新鲜事物和活动有很高的兴趣。');
INSERT INTO `perfect_test_questions` VALUES ('ActiveType', '1', 7, '我倾向于主动结识新朋友，而不是等待别人来接近我。');
INSERT INTO `perfect_test_questions` VALUES ('ActiveType', '1', 8, '我讨厌长时间独处，更喜欢有人陪伴或参与各种活动。');
INSERT INTO `perfect_test_questions` VALUES ('ActiveType', '1', 9, '我常常是团队中的活跃分子，喜欢带动大家一起参与。');
INSERT INTO `perfect_test_questions` VALUES ('ActiveType', '1', 10, '我认为生活就应该充满活力与行动，而不是安静和等待。');
INSERT INTO `perfect_test_questions` VALUES ('AgreeablenessType', '3', 1, '面对工作或生活中的压力，我通常能保持冷静并积极寻找解决办法。');
INSERT INTO `perfect_test_questions` VALUES ('AgreeablenessType', '3', 2, '当压力过大时，我容易感到焦虑、紧张，甚至影响睡眠和饮食。');
INSERT INTO `perfect_test_questions` VALUES ('AgreeablenessType', '3', 3, '我常常通过运动、听音乐或与朋友交流等方式缓解压力。');
INSERT INTO `perfect_test_questions` VALUES ('AgreeablenessType', '3', 4, '在压力情境下，我容易情绪失控，对他人发脾气或变得急躁。');
INSERT INTO `perfect_test_questions` VALUES ('AgreeablenessType', '3', 5, '我认为压力是生活的一部分，适度压力可以激发我的动力和潜力。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 1, '我常常通过艺术或创意方式表达我的情感和想法。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 2, '我对美的事物（如音乐、绘画、设计等）有很强的感知和欣赏能力。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 3, '我更喜欢通过非传统或独特的方式解决问题。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 4, '我经常沉浸在想象中，喜欢构思一些新颖的创意或故事。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 5, '我认为艺术创作是表达自我和探索内心的重要方式。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 6, '我容易被色彩、形状、声音等美学元素所吸引。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 7, '我更愿意从事能发挥我想象力和创造力的工作，而不是常规性任务。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 8, '我对艺术、文学、音乐等领域的兴趣远大于技术或逻辑类内容。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 9, '我通常不喜欢墨守成规，更倾向于尝试新奇和个性化的方式。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 10, '我认为情感和直觉在我做决定时起到很重要的作用。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 11, '我享受在自由、无拘束的环境中进行创作或思考。');
INSERT INTO `perfect_test_questions` VALUES ('ArtisticType', '1', 12, '我常常被艺术作品（如画作、音乐、电影）深深打动，并有自己的独特理解。');
INSERT INTO `perfect_test_questions` VALUES ('BileType', '3', 1, '我常常希望成为他人眼中可靠、有责任感的人，并尽力履行自己的义务。');
INSERT INTO `perfect_test_questions` VALUES ('BileType', '3', 2, '我非常关注自己的需求和享受，追求生活中快乐、刺激和满足感。');
INSERT INTO `perfect_test_questions` VALUES ('BileType', '3', 3, '我习惯照顾他人感受，乐于付出，常常把他人的需要放在自己之前。');
INSERT INTO `perfect_test_questions` VALUES ('BileType', '3', 4, '我渴望了解事情的真相与原理，喜欢分析、思考，追求知识和洞察力。');
INSERT INTO `perfect_test_questions` VALUES ('BileType', '3', 5, '我追求成功、认可与影响力，希望成为人群中的佼佼者，受人钦佩。');
INSERT INTO `perfect_test_questions` VALUES ('BileType', '3', 6, '我常常担心被抛弃或不被爱，渴望与他人建立亲密、安全的联结。');
INSERT INTO `perfect_test_questions` VALUES ('BileType', '3', 7, '我希望能保持自由、灵活，不喜欢被约束或承担责任，活在当下。');
INSERT INTO `perfect_test_questions` VALUES ('BileType', '3', 8, '我渴望被他人关注和欣赏，希望成为人群焦点，展现独特魅力。');
INSERT INTO `perfect_test_questions` VALUES ('BileType', '3', 9, '我追求内心的平静与和谐，避免冲突，善于包容和理解他人。');
INSERT INTO `perfect_test_questions` VALUES ('EmotionalType', '3', 1, '我能敏锐察觉他人的情绪变化，并给予适当回应。');
INSERT INTO `perfect_test_questions` VALUES ('EmotionalType', '3', 2, '在发生矛盾时，我通常能冷静沟通，而不是情绪化争吵。');
INSERT INTO `perfect_test_questions` VALUES ('EmotionalType', '3', 3, '我经常主动关心身边人的情绪和需要。');
INSERT INTO `perfect_test_questions` VALUES ('EmotionalType', '3', 4, '当别人批评我时，我容易感到受挫并立刻反驳。');
INSERT INTO `perfect_test_questions` VALUES ('EmotionalType', '3', 5, '即使面对压力，我也能较好地控制自己的情绪，保持理性。');
INSERT INTO `perfect_test_questions` VALUES ('ExtraversionType', '3', 1, '我觉得比平时容易紧张或着急。');
INSERT INTO `perfect_test_questions` VALUES ('ExtraversionType', '3', 2, '我无缘无故地感到害怕。');
INSERT INTO `perfect_test_questions` VALUES ('ExtraversionType', '3', 3, '我容易心里烦乱或觉得惊恐。');
INSERT INTO `perfect_test_questions` VALUES ('ExtraversionType', '3', 4, '我觉得我可能将要发疯。');
INSERT INTO `perfect_test_questions` VALUES ('ExtraversionType', '3', 5, '我觉得一切都很好，也不会发生什么不幸。');
INSERT INTO `perfect_test_questions` VALUES ('ExtraversionType', '3', 6, '我手脚发抖打颤。');
INSERT INTO `perfect_test_questions` VALUES ('ExtraversionType', '3', 7, '我因为一阵阵头晕而苦恼。');
INSERT INTO `perfect_test_questions` VALUES ('ExtraversionType', '3', 8, '我做过的事情感到不放心，反复检查。');
INSERT INTO `perfect_test_questions` VALUES ('ExtraversionType', '3', 9, '我感到心跳得很厉害。');
INSERT INTO `perfect_test_questions` VALUES ('ExtraversionType', '3', 10, '我因为胃痛和消化不良而苦恼。');
INSERT INTO `perfect_test_questions` VALUES ('ExtrovertType', '3', 1, '我倾向于追求浪漫和激情，希望恋爱充满新鲜感和强烈情感。');
INSERT INTO `perfect_test_questions` VALUES ('ExtrovertType', '3', 2, '我在选择恋爱对象时，更看重对方的实际条件，比如经济能力、家庭背景。');
INSERT INTO `perfect_test_questions` VALUES ('ExtrovertType', '3', 3, '我认为恋爱就像一场游戏，不应该太认真，享受过程更重要。');
INSERT INTO `perfect_test_questions` VALUES ('ExtrovertType', '3', 4, '我希望能完全拥有我的伴侣，不希望他与别人有过多的接触。');
INSERT INTO `perfect_test_questions` VALUES ('ExtrovertType', '3', 5, '我愿意为伴侣付出很多，甚至牺牲自己的利益来让对方幸福。');
INSERT INTO `perfect_test_questions` VALUES ('futurePrediction', '3', 1, '我对未来充满信心，相信通过努力可以实现自己的目标。');
INSERT INTO `perfect_test_questions` VALUES ('futurePrediction', '3', 2, '我经常担心未来会发生不好的事情，难以放松心态。');
INSERT INTO `perfect_test_questions` VALUES ('futurePrediction', '3', 3, '我认为未来充满变数，很难提前做出准确规划。');
INSERT INTO `perfect_test_questions` VALUES ('futurePrediction', '3', 4, '我习惯为未来制定详细的目标和计划，并努力去实现。');
INSERT INTO `perfect_test_questions` VALUES ('futurePrediction', '3', 5, '我对未来没有特别明确的想法，顺其自然就好。');
INSERT INTO `perfect_test_questions` VALUES ('happiness', '3', 1, '我常常感到生活充满意义。');
INSERT INTO `perfect_test_questions` VALUES ('happiness', '3', 2, '我容易对小事感到满足和快乐。');
INSERT INTO `perfect_test_questions` VALUES ('happiness', '3', 3, '我经常觉得自己是幸运的。');
INSERT INTO `perfect_test_questions` VALUES ('IntellectualType', '1', 1, '我常常主动阅读书籍或学习新知识来充实自己。');
INSERT INTO `perfect_test_questions` VALUES ('IntellectualType', '1', 2, '我对世界充满好奇，喜欢探索未知的事物和现象。');
INSERT INTO `perfect_test_questions` VALUES ('IntellectualType', '1', 3, '我习惯深入思考问题，而不仅仅停留在表面。');
INSERT INTO `perfect_test_questions` VALUES ('IntellectualType', '1', 4, '我喜欢和他人讨论有深度的话题，比如哲学、科学或社会问题。');
INSERT INTO `perfect_test_questions` VALUES ('IntellectualType', '1', 5, '我通常喜欢分析事情的原因和逻辑，而不仅是结果。');
INSERT INTO `perfect_test_questions` VALUES ('IntellectualType', '1', 6, '我愿意花时间去理解复杂的概念或理论。');
INSERT INTO `perfect_test_questions` VALUES ('IntellectualType', '1', 7, '我经常提出一些别人没有想到的问题或观点。');
INSERT INTO `perfect_test_questions` VALUES ('IntellectualType', '1', 8, '我享受学习新技能或掌握新知识的过程。');
INSERT INTO `perfect_test_questions` VALUES ('IntellectualType', '1', 9, '我倾向于通过阅读、研究或思考来解决生活中的问题。');
INSERT INTO `perfect_test_questions` VALUES ('IntellectualType', '1', 10, '我认为不断学习和思考是人生中非常重要的事情。');
INSERT INTO `perfect_test_questions` VALUES ('IntrovertType', '3', 1, '我能通过他人的面部表情准确判断出他们的情绪状态。');
INSERT INTO `perfect_test_questions` VALUES ('IntrovertType', '3', 2, '当有人说话语气生硬时，我能察觉到他可能正在生气或不悦。');
INSERT INTO `perfect_test_questions` VALUES ('IntrovertType', '3', 3, '我经常能从他人的肢体语言中发现他们隐藏的情绪。');
INSERT INTO `perfect_test_questions` VALUES ('IntrovertType', '3', 4, '我很难从别人的声音或表情中看出他们真正的情绪。');
INSERT INTO `perfect_test_questions` VALUES ('IntrovertType', '3', 5, '在群体交流中，我能敏锐地感知到谁情绪低落或有困扰。');
INSERT INTO `perfect_test_questions` VALUES ('LeaderType', '1', 1, '我通常能够在团队中主动承担领导角色，带领大家完成任务。');
INSERT INTO `perfect_test_questions` VALUES ('LeaderType', '1', 2, '我善于制定清晰的目标，并有效组织资源去实现它们。');
INSERT INTO `perfect_test_questions` VALUES ('LeaderType', '1', 3, '在面对问题或冲突时，我通常能够迅速做出决策。');
INSERT INTO `perfect_test_questions` VALUES ('LeaderType', '1', 4, '我能够影响他人跟随我的想法，并愿意支持我的决策。');
INSERT INTO `perfect_test_questions` VALUES ('LeaderType', '1', 5, '我习惯于掌控局面，确保事情按照计划推进。');
INSERT INTO `perfect_test_questions` VALUES ('LeaderType', '1', 6, '我能够清晰地表达自己的想法，并让别人理解我的意图。');
INSERT INTO `perfect_test_questions` VALUES ('LeaderType', '1', 7, '我通常能够激励他人，提升团队的士气和效率。');
INSERT INTO `perfect_test_questions` VALUES ('LeaderType', '1', 8, '我愿意为团队的最终结果负责，不推卸责任。');
INSERT INTO `perfect_test_questions` VALUES ('LeaderType', '1', 9, '我擅长协调不同人的意见，找到大家都能接受的方案。');
INSERT INTO `perfect_test_questions` VALUES ('LeaderType', '1', 10, '我认为一个优秀的领导者应该果断、有远见并且能带动他人。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 1, '我常常主动去帮助别人，即使他们没有明确向我求助。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 2, '我很在意别人是否喜欢我、认可我。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 3, '当别人对我表达感激时，我会感到特别开心和满足。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 4, '我常常把别人的需求放在自己的需求之前。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 5, '我害怕别人觉得我自私，所以总是尽量去满足他人。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 6, '我发现自己很难对别人说“不”，即使我内心并不愿意。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 7, '我倾向于通过照顾别人来获得爱和关注。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 8, '当我没有被别人需要时，我会感到失落或不被重视。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 9, '我经常观察别人的情绪变化，希望自己能及时给予支持。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 10, '我有时会隐藏自己的疲惫或需求，为了不让别人担心。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 11, '我觉得，如果我足够有用、足够帮助别人，我就会被人爱。');
INSERT INTO `perfect_test_questions` VALUES ('LovingType', '1', 12, '别人常常认为我是一个热心、体贴、善解人意的人。');
INSERT INTO `perfect_test_questions` VALUES ('LoyalType', '1', 1, '我非常重视对朋友和同事的承诺，说到就会做到。');
INSERT INTO `perfect_test_questions` VALUES ('LoyalType', '1', 2, '我通常能够信任他人，并愿意与他们建立长期稳定的关系。');
INSERT INTO `perfect_test_questions` VALUES ('LoyalType', '1', 3, '在团队中，我愿意承担自己的责任，并尽力完成分内的工作。');
INSERT INTO `perfect_test_questions` VALUES ('LoyalType', '1', 4, '我常常愿意为朋友或同事提供支持和帮助，即使自己比较忙。');
INSERT INTO `perfect_test_questions` VALUES ('LoyalType', '1', 5, '我认为守信和可靠是做人的基本原则之一。');
INSERT INTO `perfect_test_questions` VALUES ('LoyalType', '1', 6, '当别人对我表达信任时，我会感到责任重大，并努力不辜负他们。');
INSERT INTO `perfect_test_questions` VALUES ('LoyalType', '1', 7, '我倾向于维护团队的和谐，不轻易破坏团队的合作关系。');
INSERT INTO `perfect_test_questions` VALUES ('LoyalType', '1', 8, '即使面对困难，我也会坚持履行我对他人作出的承诺。');
INSERT INTO `perfect_test_questions` VALUES ('LoyalType', '1', 9, '我通常不会轻易改变对某人或某事的信任，一旦建立就比较持久。');
INSERT INTO `perfect_test_questions` VALUES ('LoyalType', '1', 10, '我认为忠诚和信任是维系人际关系的重要基础。');
INSERT INTO `perfect_test_questions` VALUES ('MelancholicType', '3', 1, '在恋爱关系中，我常常希望与伴侣时刻保持紧密联系。');
INSERT INTO `perfect_test_questions` VALUES ('MelancholicType', '3', 2, '当伴侣暂时不回消息时，我会感到不安甚至焦虑。');
INSERT INTO `perfect_test_questions` VALUES ('MelancholicType', '3', 3, '我倾向于在感情中保持一定的独立性，不过分依赖对方。');
INSERT INTO `perfect_test_questions` VALUES ('MelancholicType', '3', 4, '我担心自己不被伴侣真正接纳或深爱。');
INSERT INTO `perfect_test_questions` VALUES ('MelancholicType', '3', 5, '在恋爱中，我通常不会轻易向伴侣表达内心的脆弱与需求。');
INSERT INTO `perfect_test_questions` VALUES ('OpennessType', '3', 1, '我感到情绪沮丧，郁闷');
INSERT INTO `perfect_test_questions` VALUES ('OpennessType', '3', 2, '我对未来感到没有希望');
INSERT INTO `perfect_test_questions` VALUES ('OpennessType', '3', 3, '我比平时更容易哭泣');
INSERT INTO `perfect_test_questions` VALUES ('OpennessType', '3', 4, '我感到闷闷不乐，没有精神');
INSERT INTO `perfect_test_questions` VALUES ('OpennessType', '3', 5, '我对以前喜欢的事情失去兴趣');
INSERT INTO `perfect_test_questions` VALUES ('OpennessType', '3', 6, '我感到自己毫无价值，或过分自责');
INSERT INTO `perfect_test_questions` VALUES ('OpennessType', '3', 7, '我难以集中注意力，比如读报纸或看电视时');
INSERT INTO `perfect_test_questions` VALUES ('OpennessType', '3', 8, '我觉得做决定很困难');
INSERT INTO `perfect_test_questions` VALUES ('OpennessType', '3', 9, '我比平时睡得少，或者睡眠过多');
INSERT INTO `perfect_test_questions` VALUES ('OpennessType', '3', 10, '我有死亡或自杀的念头');
INSERT INTO `perfect_test_questions` VALUES ('PeaceType', '1', 1, '我通常性格温和，很少与他人发生争执或冲突。');
INSERT INTO `perfect_test_questions` VALUES ('PeaceType', '1', 2, '我能够包容他人的不同意见，不会强行要求别人与自己一致。');
INSERT INTO `perfect_test_questions` VALUES ('PeaceType', '1', 3, '我倾向于避免冲突，更愿意通过平和方式解决问题。');
INSERT INTO `perfect_test_questions` VALUES ('PeaceType', '1', 4, '我通常情绪稳定，不容易被外界干扰或激怒。');
INSERT INTO `perfect_test_questions` VALUES ('PeaceType', '1', 5, '我愿意倾听他人的想法，即使与我的观点不同。');
INSERT INTO `perfect_test_questions` VALUES ('PeaceType', '1', 6, '我在团队中通常扮演协调者角色，帮助大家和谐相处。');
INSERT INTO `perfect_test_questions` VALUES ('PeaceType', '1', 7, '我更喜欢平静、安定的环境，不喜欢过于激烈的竞争或对抗。');
INSERT INTO `perfect_test_questions` VALUES ('PeaceType', '1', 8, '我能够耐心地与人沟通，不会急于表达自己的立场。');
INSERT INTO `perfect_test_questions` VALUES ('PeaceType', '1', 9, '我通常不会主动去争夺权力或控制局面。');
INSERT INTO `perfect_test_questions` VALUES ('PeaceType', '1', 10, '我认为和谐的人际关系比争强好胜更重要。');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 1, '我对自己的任务（如作业、工作项目），通常会要求：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 2, '如果一件事的结果没达到「最好」（比如比赛拿银牌/项目评分85分），我的感受是：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 3, '当别人（如同事/朋友）认为某件事「足够好」时，我的想法是：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 4, '我是否会因为担心犯错（如说错话、写错数据）而反复检查或拖延行动？');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 5, '当看到别人（如同学/同事）的成果未达到我的标准时，我的反应是：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 6, '我对自己犯明显错误（如考试算错简单题、工作漏掉关键步骤）的态度是：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 7, '为了把事情做到理想状态，我是否愿意花额外时间反复打磨（即使可能耽误进度）？');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 8, '当任务结果未达我的预期时，我的情绪反应是：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 9, '我对生活中细节（如家居整洁度、穿着搭配、文件命名规则）的要求是：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 10, '如果他人对我的工作/成果提出轻微批评（如「这里格式可以优化」），我的反应是：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 11, '我习惯为自己设定目标时，通常是：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 12, '我对「足够好」和「完美」的看法是：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 13, '当无法达到自己设定的标准时，我的情绪是：');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 14, '我是否曾因为追求细节完美而影响整体进度（如写报告时纠结用词耽误交稿时间）？');
INSERT INTO `perfect_test_questions` VALUES ('PerfectType', '1', 15, '我认为「优秀」和「完美」的关系是：');
INSERT INTO `perfect_test_questions` VALUES ('PhlegmaticType', '3', 1, '我喜欢尝试新事物，对新鲜想法和经历充满好奇。');
INSERT INTO `perfect_test_questions` VALUES ('PhlegmaticType', '3', 2, '我通常会按时完成任务，并认真负责地对待工作。');
INSERT INTO `perfect_test_questions` VALUES ('PhlegmaticType', '3', 3, '我在社交场合中通常很活跃，喜欢与人交谈。');
INSERT INTO `perfect_test_questions` VALUES ('PhlegmaticType', '3', 4, '我通常愿意帮助别人，即使这对我没有直接好处。');
INSERT INTO `perfect_test_questions` VALUES ('PhlegmaticType', '3', 5, '我经常感到紧张、担忧或情绪波动较大。');
INSERT INTO `perfect_test_questions` VALUES ('PhlegmaticType', '3', 6, '我乐于接受不同的观点，对艺术和抽象概念感兴趣。');
INSERT INTO `perfect_test_questions` VALUES ('PhlegmaticType', '3', 7, '我是一个可靠的人，别人可以信任我完成承诺的事。');
INSERT INTO `perfect_test_questions` VALUES ('PhlegmaticType', '3', 8, '我更喜欢独处或与少数几个亲密朋友相处，而不是大型社交活动。');
INSERT INTO `perfect_test_questions` VALUES ('PhlegmaticType', '3', 9, '我通常很容易与他人合作，不喜欢与人争执。');
INSERT INTO `perfect_test_questions` VALUES ('PhlegmaticType', '3', 10, '我容易因为小事感到烦躁或情绪低落。');
INSERT INTO `perfect_test_questions` VALUES ('RationalType', '3', 1, '当我感到愤怒时，我通常能控制自己不立刻发脾气。');
INSERT INTO `perfect_test_questions` VALUES ('RationalType', '3', 2, '我能够识别自己情绪变化的原因，并理解情绪背后的真实需求。');
INSERT INTO `perfect_test_questions` VALUES ('RationalType', '3', 3, '在遇到挫折时，我容易陷入长时间的消极情绪中难以自拔。');
INSERT INTO `perfect_test_questions` VALUES ('RationalType', '3', 4, '面对压力，我能够保持相对冷静，并采取合理的方式应对。');
INSERT INTO `perfect_test_questions` VALUES ('RationalType', '3', 5, '我常常因为一点小事就情绪波动很大，难以平复心情。');
INSERT INTO `perfect_test_questions` VALUES ('SanguineType', '3', 1, '在团队中，我通常主动承担责任并推动事情进展。');
INSERT INTO `perfect_test_questions` VALUES ('SanguineType', '3', 2, '我倾向于关注他人的感受，并努力维持和谐氛围。');
INSERT INTO `perfect_test_questions` VALUES ('SanguineType', '3', 3, '我更喜欢按计划和规则办事，不喜欢临时变动。');
INSERT INTO `perfect_test_questions` VALUES ('SanguineType', '3', 4, '我通常很随和，能适应不同人的需求和变化。');
INSERT INTO `perfect_test_questions` VALUES ('SanguineType', '3', 5, '我乐于表达自己，喜欢成为人群中的焦点。');
INSERT INTO `perfect_test_questions` VALUES ('WillpowerType', '3', 1, '我能设身处地理解他人的感受，即使我不认同他们的观点。');
INSERT INTO `perfect_test_questions` VALUES ('WillpowerType', '3', 2, '当朋友向我倾诉烦恼时，我通常能认真倾听并理解他们的心情。');
INSERT INTO `perfect_test_questions` VALUES ('WillpowerType', '3', 3, '我经常能察觉到别人情绪低落，即使他们没有明确说出来。');
INSERT INTO `perfect_test_questions` VALUES ('WillpowerType', '3', 4, '看到他人遭遇不幸时，我很难产生共鸣或同情心。');
INSERT INTO `perfect_test_questions` VALUES ('WillpowerType', '3', 5, '在与他人交流时，我会主动考虑对方的立场和感受。');

SET FOREIGN_KEY_CHECKS = 1;
