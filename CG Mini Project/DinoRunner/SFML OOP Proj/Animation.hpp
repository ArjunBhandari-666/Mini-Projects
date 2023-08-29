#pragma once

#include <vector>
#include <SFML/Graphics/Rect.hpp>
#include <SFML/Graphics/Texture.hpp>

class Animation
{
public:
    Animation();

    void addFrame(sf::IntRect rect);    //Uses vectors to pushback the frames in an animation.
    void setSpriteSheet(const sf::Texture& texture);    //Sets the spritesheet texture
    const sf::Texture* getSpriteSheet() const;          //Get the texture of the sprite sheet.
    std::size_t getSize() const;                        //Get size of the animation.
    const sf::IntRect& getFrame(std::size_t n) const;   //Sets the texture areas to display per frame.

private:
    std::vector<sf::IntRect> m_frames;                  //Vector that stores all the frames.
    const sf::Texture* m_texture;                       //Texture pointer to the texture that we want to load.
};