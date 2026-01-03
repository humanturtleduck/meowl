package net.humanturtleduck.meowl.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ModAnimationsDefinitions {
    public static final AnimationDefinition MEOWL_WINGIDLE = AnimationDefinition.Builder.withLength(3.5f)
            .addAnimation("rightwing",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.degreeVec(-60f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.20833f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.29167f, KeyframeAnimations.degreeVec(-40f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftwing",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.degreeVec(60f, 0f, -2.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.20833f, KeyframeAnimations.degreeVec(20f, 0f, -2.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.29167f, KeyframeAnimations.degreeVec(40f, 0f, -2.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.degreeVec(20f, 0f, -2.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("uppermeowl",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition MEOWL_FART = AnimationDefinition.Builder.withLength(0.58333f)
            .addAnimation("body",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.16667f, KeyframeAnimations.degreeVec(0f, 2.5f, 10f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.20833f, KeyframeAnimations.degreeVec(0f, -3.12f, 10f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.33333f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.58333f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition MEOWL_WALK = AnimationDefinition.Builder.withLength(0.625f).looping()
            .addAnimation("rightleg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, -25f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.16667f, KeyframeAnimations.degreeVec(0f, 0f, -25f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.29167f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("leftleg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.29167f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.41667f, KeyframeAnimations.degreeVec(0f, 0f, -25f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.45833f, KeyframeAnimations.degreeVec(0f, 0f, -25f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.58333f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("uppermeowl",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.125f, KeyframeAnimations.posVec(0f, 0.1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.29167f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.41667f, KeyframeAnimations.posVec(0f, 0.1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.58333f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();

}
