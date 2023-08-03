package com.example.testapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean isMuted = false;

    private ImageView iconImageView;

    private ImageView githubImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flirtyTextView = findViewById(R.id.flirtytextView1);
        mediaPlayer = MediaPlayer.create(this, R.raw.lovestory);
        mediaPlayer.setLooping(true);

        iconImageView = findViewById(R.id.imageView);

        githubImageView = findViewById(R.id.imageView6);
        githubImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                githubClick();
            }
        });
    }

    private TextView flirtyTextView;

    private String[] flirtySentences = {
            // Add the 100 flirty messages here...
            "If this were a love story, you'd be the leading role in my heart. Your charm is like a beautiful melody that never fades away.",
            "Just like Taylor Swift's love story, I can't help but feel butterflies in my stomach whenever I'm near you. You're the missing piece to my love song.",
            "If love is a journey, then meeting you feels like destiny. Your smile is as enchanting as Taylor's lyrics, and I'm under your spell.",
            "In this love story, our hearts entwine like a perfect dance. I can't help but fall for you, just like Taylor fell for her Romeo.",
            "You're the Romeo to my Juliet, and our love story is just beginning. Taylor Swift would be proud of the magic we share.",
            "In the pages of our love story, you're the hero who sweeps me off my feet. I'm enchanted by your presence, just like Taylor sings.",
            "Let's make our own love story, where the plot is filled with laughter and the ending is a happily ever after. You're the protagonist of my heart.",
            "If this were a love story, you'd be the chorus that plays on repeat in my mind. Your voice and laughter make my heart skip a beat.",
            "Our love story is like a fairytale, and I feel like the luckiest person to have you by my side. You're the Prince Charming to my Cinderella.",
            "Just like Taylor Swift's love story, you've captured my heart and made it your home. Let's create our own beautiful journey together.",
            "If I were a genie, I'd grant you three wishes, but my first wish would be for you to be mine forever.",
            "If our love were a song, it'd be a chart-topping hit. We have the kind of chemistry that can't be denied.",
            "Is it hot in here, or is it just the sparks flying between us? Our chemistry is off the charts.",
            "If love were a game, you'd be the MVP. You have a way of winning me over every time.",
            "I must be dreaming because being with you feels too good to be true. You make every moment magical.",
            "They say love is blind, but with you, it's like I see the world in a whole new light.",
            "You must be a magician because every time I look into your eyes, I get lost in your spell.",
            "If I were a cat, I'd spend all nine lives with you. You're the purr-fect match for me.",
            "Your smile could light up the darkest night. It's contagious, and I can't help but smile back.",
            "If you were a song, you'd be the one stuck in my head all day. You're my favorite melody.",
            "If I were a poet, I'd write sonnets about you. You're the muse that inspires my heart.",
            "If kisses were raindrops, I'd send you a storm. I can't get enough of your sweet affection.",
            "Your laughter is like music to my ears, and I can't help but join in on the joy you bring.",
            "If our love were a dance, I'd want to slow dance with you every night. You're my perfect partner.",
            "You're more addictive than chocolate, and I can't resist indulging in your love.",
            "If our love were a fairytale, you'd be the charming prince, and I'd be the lucky princess.",
            "You must be a shooting star because you've brightened up my life in an instant.",
            "If love were a drug, I'd be addicted to you. You're my ultimate high.",
            "If I were a puzzle, you'd be the missing piece I've been searching for all my life.",
            "If our love were a movie, it'd be a romantic blockbuster. Our story is one for the ages.",
            "If I were a baker, I'd bake you the sweetest treats because you're the icing on my cake.",
            "If I were a magician, I'd conjure up a world where it's just you and me, forever.",
            "Your eyes are like pools of enchantment, and I'm drawn to their depths every time.",
            "If love were a game, I'd play to win your heart. You're worth every effort.",
            "If I were an artist, I'd paint you as the masterpiece you truly are. You're a work of art.",
            "If our love were a journey, I'd want it to last a lifetime. You're my destination.",
            "If I were a gardener, I'd plant a garden with flowers that remind me of you – beautiful and captivating.",
            "If you were a star, you'd shine the brightest in the night sky. You're my guiding light.",
            "If our love were a book, I'd never want to reach the last page. Our story is worth savoring.",
            "If I were a poet, I'd write verses about the beauty of your soul. You're extraordinary.",
            "If I were a pilot, I'd fly us to the most romantic places on Earth. You make every moment special.",
            "If our love were a firework, it'd light up the sky with brilliance and wonder.",
            "If I were a weather forecast, I'd predict a shower of love when you're near.",
            "If love were a treasure hunt, I'd follow the clues to find you. You're the ultimate prize.",
            "If I were a time traveler, I'd go back in time to meet you sooner. You're the missing piece of my life's puzzle.",
            "If our love were a song, it'd be a ballad that touches hearts and leaves a lasting impression.",
            "If I were a photographer, I'd capture every moment with you because each one is a precious memory.",
            "If you were a flower, you'd be the most exquisite bloom in the garden. You're simply breathtaking.",
            "If love were a fairytale, I'd want to be the knight in shining armor, protecting your heart.",
            "If I were a chef, I'd cook the most romantic meals for you. You're the flavor that spices up my life.",
            "If you were a poem, you'd be the one that rhymes perfectly with my heart.",
            "If our love were a constellation, it'd shine the brightest in the night sky. You're my guiding star.",
            "If I were a novelist, I'd pen the most beautiful love story with you as the protagonist.",
            "If love were a painting, it'd be a masterpiece with you as the subject. You're captivating.",
            "If I were a genie, I'd grant your every wish. Your happiness is my priority.",
            "If our love were a symphony, it'd be the most harmonious and melodious music to my ears.",
            "If I were a scientist, I'd study the magic of our connection. You're the greatest discovery of my life.",
            "If you were a diamond, you'd be the rarest and most precious gem in the world. You're irreplaceable.",
            "If love were a dance, I'd want to waltz with you through life. You're my perfect partner.",
            "If I were a musician, I'd write love songs dedicated to you. You're my muse.",
            "If our love were a puzzle, it'd be a perfect fit. You complete me.",
            "If I were a traveler, I'd journey to the ends of the Earth to find you. You're my destination.",
            "If you were a raindrop, you'd be the one that brings life to a dry desert. You're my source of joy.",
            "If love were a dessert, you'd be the sweetest and most delightful treat. You satisfy my soul.",
            "If I were a poet, I'd write epic verses about our love. You're the story worth telling.",
            "If our love were a river, it'd flow endlessly, carrying us to new horizons.",
            "If I were a sculptor, I'd carve a statue of you – a symbol of beauty and grace.",
            "If you were a dream, I'd never want to wake up. You're my sweetest fantasy.",
            "If love were a language, you'd be the eloquent words that express my feelings.",
            "If I were an astronaut, I'd travel to the stars and back, just to be by your side.",
            "If our love were a song, it'd be the anthem that unites our hearts.",
            "If I were a photographer, I'd capture every smile you grace me with. You light up my world.",
            "If you were a book, you'd be the one I'd read again and again. Your story fascinates me.",
            "If love were a journey, you'd be the road that leads to happiness and fulfillment.",
            "If I were an artist, I'd paint a canvas with colors that reflect the beauty of your soul.",
            "If our love were a flame, it'd burn brightly, warming our hearts and souls.",
            "If I were a poet, I'd write verses about the magic of our connection. You're my inspiration.",
            "If you were a star, you'd be the one that shines the brightest in my sky.",
            "If love were a melody, you'd be the song that plays on repeat in my heart.",
            "If I were a pilot, I'd fly us to the most romantic destinations on Earth.",
            "If our love were a flower, you'd be the bloom that blossoms with beauty and grace.",
            "If I were a time traveler, I'd choose to spend eternity with you in every moment.",
            "If you were a song, you'd be the one that tugs at my heartstrings.",
            "If love were a treasure, you'd be the priceless gem I'd cherish forever.",
            "If I were a weather forecaster, I'd predict endless days of sunshine whenever you're near.",
            "If our love were a puzzle, you'd be the piece that completes me.",
            "If I were a chef, I'd cook up the most delectable dishes to satisfy your heart.",
            "If you were a poem, you'd be the verses that leave me breathless.",
            "If love were a fairytale, you'd be the magical character that fills my dreams.",
            "If I were a novelist, I'd write a saga of our love that spans through time.",
            "If our love were a constellation, you'd be the brightest star that guides me.",
            "If I were a scientist, I'd study the chemistry of our affection. It's intoxicating.",
            "If you were a diamond, you'd be the gem that sparkles with brilliance and allure.",
            "If love were a dance, you'd be the partner I'd waltz with forever.",
            "If I were a musician, I'd compose a symphony that celebrates our love.",
            "If our love were a puzzle, it'd be the one I'd never grow tired of solving.",
            "If I were a traveler, I'd journey to every corner of the Earth with you by my side.",
            "If you were a raindrop, you'd be the one that refreshes my soul and quenches my thirst for love.",
            "If love were a dessert, you'd be the sweet treat that leaves me wanting more.",
            "If I were a poet, I'd write verses that capture the essence of our romance.",
            "If our love were a river, it'd flow endlessly, guiding us on our journey together.",
            "If I were a sculptor, I'd create a masterpiece that reflects the beauty of your heart.",
            "If you were a dream, I'd never want to wake up. You're my beautiful reverie.",
            "If love were a language, you'd be the eloquent words that express my feelings.",
            "If I were an astronaut, I'd explore the universe with you as my co-pilot.",
            "If our love were a song, it'd be the melody that sings in harmony with our hearts.",
            "If I were a photographer, I'd capture every moment with you, for they're the most cherished.",
            "If you were a book, you'd be the one I'd read again and again, for your story captivates me.",
            "If love were a journey, you'd be the road that leads to happiness and fulfillment.",
            "If I were an artist, I'd paint a canvas with colors that reflect the beauty of your soul.",
            "If our love were a flame, it'd burn brightly, warming our hearts and souls.",
            "If I were a poet, I'd write verses about the magic of our connection. You're my inspiration.",
            "If you were a star, you'd be the one that shines the brightest in my sky.",
            "If love were a melody, you'd be the song that plays on repeat in my heart.",
            "If I were a pilot, I'd fly us to the most romantic destinations on Earth.",
            "If our love were a flower, you'd be the bloom that blossoms with beauty and grace.",
            "If I were a time traveler, I'd choose to spend eternity with you in every moment.",
            "If you were a song, you'd be the one that tugs at my heartstrings.",
            "If love were a treasure, you'd be the priceless gem I'd cherish forever.",
            "If I were a weather forecaster, I'd predict endless days of sunshine whenever you're near.",
            "If our love were a puzzle, you'd be the piece that completes me.",
            "If I were a chef, I'd cook up the most delectable dishes to satisfy your heart.",
            "If you were a poem, you'd be the verses that leave me breathless.",
            "If love were a fairytale, you'd be the magical character that fills my dreams.",
            "If I were a novelist, I'd write a saga of our love that spans through time.",
            "If our love were a constellation, you'd be the brightest star that guides me.",
            "If I were a scientist, I'd study the chemistry of our affection. It's intoxicating.",
            "If you were a diamond, you'd be the gem that sparkles with brilliance and allure.",
            "If love were a dance, you'd be the partner I'd waltz with forever.",
            "If I were a musician, I'd compose a symphony that celebrates our love.",
            "If our love were a puzzle, it'd be the one I'd never grow tired of solving.",
            "If I were a traveler, I'd journey to every corner of the Earth with you by my side.",
            "If you were a raindrop, you'd be the one that refreshes my soul and quenches my thirst for love.",
            "If love were a dessert, you'd be the sweet treat that leaves me wanting more.",
            "If I were a poet, I'd write verses that capture the essence of our romance.",
            "If our love were a river, it'd flow endlessly, guiding us on our journey together.",
            "If I were a sculptor, I'd create a masterpiece that reflects the beauty of your heart.",
            "If you were a dream, I'd never want to wake up. You're my beautiful reverie.",
            "If love were a language, you'd be the eloquent words that express my feelings.",
            "If I were an astronaut, I'd explore the universe with you as my co-pilot.",
            "If our love were a song, it'd be the melody that sings in harmony with our hearts.",
            "If I were a photographer, I'd capture every moment with you, for they're the most cherished.",
            "If you were a book, you'd be the one I'd read again and again, for your story captivates me.",
            "If love were a journey, you'd be the road that leads to happiness and fulfillment.",
            "If I were an artist, I'd paint a canvas with colors that reflect the beauty of your soul.",
            "If our love were a flame, it'd burn brightly, warming our hearts and souls.",
            "If I were a poet, I'd write verses about the magic of our connection. You're my inspiration.",
            "If you were a star, you'd be the one that shines the brightest in my sky.",
            "If love were a melody, you'd be the song that plays on repeat in my heart.",
            "If I were a pilot, I'd fly us to the most romantic destinations on Earth.",
            "If our love were a flower, you'd be the bloom that blossoms with beauty and grace.",
            "If I were a time traveler, I'd choose to spend eternity with you in every moment.",
            "If you were a song, you'd be the one that tugs at my heartstrings.",
            "If love were a treasure, you'd be the priceless gem I'd cherish forever.",
            "If I were a weather forecaster, I'd predict endless days of sunshine whenever you're near.",
            "If our love were a puzzle, you'd be the piece that completes me.",
            "If I were a chef, I'd cook up the most delectable dishes to satisfy your heart.",
            "If you were a poem, you'd be the verses that leave me breathless.",
            "If love were a fairytale, you'd be the magical character that fills my dreams.",
            "If I were a novelist, I'd write a saga of our love that spans through time.",
            "If our love were a constellation, you'd be the brightest star that guides me.",
            "If I were a scientist, I'd study the chemistry of our affection. It's intoxicating.",
            "If you were a diamond, you'd be the gem that sparkles with brilliance and allure.",
            "If love were a dance, you'd be the partner I'd waltz with forever.",
            "If I were a musician, I'd compose a symphony that celebrates our love.",
            "If our love were a puzzle, it'd be the one I'd never grow tired of solving.",
            "If I were a traveler, I'd journey to every corner of the Earth with you by my side.",
            "If you were a raindrop, you'd be the one that refreshes my soul and quenches my thirst for love.",
            "If love were a dessert, you'd be the sweet treat that leaves me wanting more.",
            "If I were a poet, I'd write verses that capture the essence of our romance.",
            "If our love were a river, it'd flow endlessly, guiding us on our journey together.",
            "If I were a sculptor, I'd create a masterpiece that reflects the beauty of your heart.",
            "If you were a dream, I'd never want to wake up. You're my beautiful reverie.",
            "If love were a language, you'd be the eloquent words that express my feelings.",
            "If I were an astronaut, I'd explore the universe with you as my co-pilot.",
            "If our love were a song, it'd be the melody that sings in harmony with our hearts.",
            "If I were a photographer, I'd capture every moment with you, for they're the most cherished.",
            "If you were a book, you'd be the one I'd read again and again, for your story captivates me.",
            "If love were a journey, you'd be the road that leads to happiness and fulfillment.",
            "If I were an artist, I'd paint a canvas with colors that reflect the beauty of your soul.",
            "If our love were a flame, it'd burn brightly, warming our hearts and souls.",
            "If I were a poet, I'd write verses about the magic of our connection. You're my inspiration.",
            "If you were a star, you'd be the one that shines the brightest in my sky.",
            "If love were a melody, you'd be the song that plays on repeat in my heart.",
            "If I were a pilot, I'd fly us to the most romantic destinations on Earth.",
            "If our love were a flower, you'd be the bloom that blossoms with beauty and grace.",
            "If I were a time traveler, I'd choose to spend eternity with you in every moment.",
            "If you were a song, you'd be the one that tugs at my heartstrings.",
            "If love were a treasure, you'd be the priceless gem I'd cherish forever.",
            "If I were a weather forecaster, I'd predict endless days of sunshine whenever you're near.",
            "If our love were a puzzle, you'd be the piece that completes me.",
            "If I were a chef, I'd cook up the most delectable dishes to satisfy your heart.",
            "If you were a poem, you'd be the verses that leave me breathless.",
            "If love were a fairytale, you'd be the magical character that fills my dreams.",
            "If I were a novelist, I'd write a saga of our love that spans through time.",
            "If our love were a constellation, you'd be the brightest star that guides me.",
            "If I were a scientist, I'd study the chemistry of our affection. It's intoxicating.",
            "If you were a diamond, you'd be the gem that sparkles with brilliance and allure.",
            "If love were a dance, you'd be the partner I'd waltz with forever.",
            "If I were a musician, I'd compose a symphony that celebrates our love.",
            "If our love were a puzzle, it'd be the one I'd never grow tired of solving.",
            "If I were a traveler, I'd journey to every corner of the Earth with you by my side.",
            "If you were a raindrop, you'd be the one that refreshes my soul and quenches my thirst for love.",
            "If love were a dessert, you'd be the sweet treat that leaves me wanting more.",
            "If I were a poet, I'd write verses that capture the essence of our romance.",
            "If our love were a river, it'd flow endlessly, guiding us on our journey together.",
            "If I were a sculptor, I'd create a masterpiece that reflects the beauty of your heart.",
            "If you were a dream, I'd never want to wake up. You're my beautiful reverie.",
            "If love were a language, you'd be the eloquent words that express my feelings.",
            "If I were an astronaut, I'd explore the universe with you as my co-pilot.",
            "If our love were a song, it'd be the melody that sings in harmony with our hearts.",
            "If I were a photographer, I'd capture every moment with you, for they're the most cherished.",
            "If you were a book, you'd be the one I'd read again and again, for your story captivates me.",
            "If love were a journey, you'd be the road that leads to happiness and fulfillment.",
            "If I were an artist, I'd paint a canvas with colors that reflect the beauty of your soul.",
            "If our love were a flame, it'd burn brightly, warming our hearts and souls.",
            "If I were a poet, I'd write verses about the magic of our connection. You're my inspiration.",
            "If you were a star, you'd be the one that shines the brightest in my sky.",
            "If love were a melody, you'd be the song that plays on repeat in my heart.",
            "If I were a pilot, I'd fly us to the most romantic destinations on Earth.",
            "If our love were a flower, you'd be the bloom that blossoms with beauty and grace.",
            "If I were a time traveler, I'd choose to spend eternity with you in every moment.",
            "If you were a song, you'd be the one that tugs at my heartstrings.",
            "If love were a treasure, you'd be the priceless gem I'd cherish forever.",
            "If I were a weather forecaster, I'd predict endless days of sunshine whenever you're near.",
            "If our love were a puzzle, you'd be the piece that completes me.",
            "If I were a chef, I'd cook up the most delectable dishes to satisfy your heart.",
            "If you were a poem, you'd be the verses that leave me breathless.",
            "If love were a fairytale, you'd be the magical character that fills my dreams.",
            "If I were a novelist, I'd write a saga of our love that spans through time.",
            "If our love were a constellation, you'd be the brightest star that guides me.",
            "If I were a scientist, I'd study the chemistry of our affection. It's intoxicating.",
            "If you were a diamond, you'd be the gem that sparkles with brilliance and allure."
    };


    public void generateBtn(View v) {
        if (flirtySentences != null && flirtySentences.length > 0) {
            Random random = new Random();
            int index = random.nextInt(flirtySentences.length);
            String flirtyText = flirtySentences[index];
            flirtyTextView.setText(flirtyText);
        } else {
            flirtyTextView.setText("No flirty sentences available.");
        }
    }

    public void copyBtn(View v) {
        String flirtText = flirtyTextView.getText().toString();

        if (!flirtText.isEmpty()) {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Flirty Text", flirtText);
            clipboard.setPrimaryClip(clip);

            Toast.makeText(this, "copied to clipboard!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    public void setMuted(View v) {
        if (isMuted) {
            mediaPlayer.setVolume(1.0f, 1.0f);
            isMuted = false;
            iconImageView.setImageResource(R.drawable.volume);
            Toast.makeText(this, "Play!", Toast.LENGTH_SHORT).show();
        } else {
            mediaPlayer.setVolume(0.0f, 0.0f);
            isMuted = true;
            iconImageView.setImageResource(R.drawable.mute);
            Toast.makeText(this, "Muted!", Toast.LENGTH_SHORT).show();
        }
    }

        public void githubClick(){
            String githubProfileUrl = "https://github.com/meruuuuooo";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubProfileUrl));
            startActivity(intent);
        }

}